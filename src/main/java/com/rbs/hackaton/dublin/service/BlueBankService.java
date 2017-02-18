package com.rbs.hackaton.dublin.service;

import com.google.common.annotations.VisibleForTesting;
import com.rbs.hackaton.dublin.model.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class BlueBankService {

    private static final String SUBSCRIPTION_HEADER = "Ocp-Apim-Subscription-Key";
    private static final String SUBSCRIPTION_VALUE = "7290d8c354ee40818236118770cfa146";
    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String AUTHORIZATION_VALUE = "Bearer %s";

    private static final String BLUEBANK_BASE = "https://bluebank.azure-api.net//api/v0.7";
    private static final String CUSTOMERS = "/customers";
    private static final String ACCOUNTS = "/customers/%s/accounts";
    private static final String TRANSACTIONS = "/accounts/%s/transactions";

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.SSS'Z'");

    public List<AccountInformation> getAccountInformation(String token) {

        Customer customer = getCustomer(token);
        List<Account> accounts = getAccounts(customer.id(), token);
        return accounts.stream().map(account -> getInformation(account, token)).collect(Collectors.toList());
    }

    public Customer getCustomer(String token) {

        RestTemplate restTemplate = restTemplate(token);
        CustomerResults customers = restTemplate.getForObject(BLUEBANK_BASE + CUSTOMERS, CustomerResults.class);
        return customers.results().get(0);
    }

    @VisibleForTesting
    List<Account> getAccounts(String customer, String token) {

        RestTemplate restTemplate = restTemplate(token);
        AccountResults accounts = restTemplate.getForObject(BLUEBANK_BASE
                + String.format(ACCOUNTS, customer), AccountResults.class);
        return accounts.results();
    }

    @VisibleForTesting
    List<Transaction> getTransactions(String account, String token) {

        RestTemplate restTemplate = restTemplate(token);
        TransactionResults transactions = restTemplate.getForObject(BLUEBANK_BASE
                + String.format(TRANSACTIONS, account), TransactionResults.class);
        return transactions.results();
    }

    Map<String, BigDecimal> sortByMonth(List<Transaction> transactions, boolean incoming) {

        Map<String, BigDecimal> byMonth = new LinkedHashMap<>();
        transactions.stream().filter(t -> incoming ?
                t.amount().compareTo(BigDecimal.ZERO) >= 0 :
                t.amount().compareTo(BigDecimal.ZERO) < 0)
            .forEach(t -> {
                GregorianCalendar cal = null;
                try {
                    cal = new GregorianCalendar();
                    cal.setTime(DATE_FORMAT.parse(t.timestamp()));
                } catch (ParseException e) {
                    // ignore for the demo
                }
                String key = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1);

                BigDecimal current = byMonth.getOrDefault(key, BigDecimal.ZERO);
                byMonth.put(key, current.add(t.amount()));
            });

        return byMonth;
    }

    private AccountInformation getInformation(Account account, String token) {

        AccountInformation info = new AccountInformation()
                .accountNumber(account.accountNumber())
                .sortCode(account.sortCode())
                .balance(account.accountBalance());

        List<Transaction> transactions = getTransactions(account.id(), token);

        info.monthlyIncomings(sortByMonth(transactions, true));
        info.monthlyOutgoings(sortByMonth(transactions, true));

        return info;
    }

    private RestTemplate restTemplate(String token) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(Collections.singletonList(new BlueBankInterceptor(token)));
        return restTemplate;
    }

    private class BlueBankInterceptor implements ClientHttpRequestInterceptor {

        private String token;

        private BlueBankInterceptor(String token) {
            this.token = token;
        }

        @Override
        public ClientHttpResponse intercept(
                HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
                throws IOException {

            HttpHeaders headers = request.getHeaders();
            headers.set(SUBSCRIPTION_HEADER, SUBSCRIPTION_VALUE);
            headers.set(AUTHORIZATION_HEADER, String.format(AUTHORIZATION_VALUE, token));
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            return execution.execute(request, body);
        }
    }
}
