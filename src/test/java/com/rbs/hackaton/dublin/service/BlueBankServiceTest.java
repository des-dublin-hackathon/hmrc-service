package com.rbs.hackaton.dublin.service;

import com.google.common.collect.Lists;
import com.rbs.hackaton.dublin.model.Account;
import com.rbs.hackaton.dublin.model.Customer;
import com.rbs.hackaton.dublin.model.Transaction;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BlueBankServiceTest {

    private final String TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6ImdmSUtJSC15WjNwaFJIUnlqbnNISXFaTWFlUExHQUVMelBhdDBDTlk0c0EifQ.eyJleHAiOjE0ODc0MzkyMzAsIm5iZiI6MTQ4NzQzNTYzMCwidmVyIjoiMS4wIiwiaXNzIjoiaHR0cHM6Ly9sb2dpbi5taWNyb3NvZnRvbmxpbmUuY29tL2Q1Zjg1NjgyLWY2N2EtNDQ0NC05MzY5LTJjNWVjMWEwZThjZC92Mi4wLyIsInN1YiI6ImE5MzE0M2ExLTJjYjQtNDIwNS1hNjgxLTNkNzJmZTcxNjI4ZCIsImF1ZCI6IjBmN2VmODEwLTJmOWMtNDI0Yy05NDJhLTQ4YzZlYTM2MWQ5YSIsIm5vbmNlIjoiZGVmYXVsdE5vbmNlIiwiaWF0IjoxNDg3NDM1NjMwLCJhdXRoX3RpbWUiOjE0ODc0MzU2MzAsIm9pZCI6ImE5MzE0M2ExLTJjYjQtNDIwNS1hNjgxLTNkNzJmZTcxNjI4ZCIsIm5hbWUiOiJzZ2Vyb2dpYSIsImZhbWlseV9uYW1lIjoiR2Vyb2dpYW5uYWtpcyIsImdpdmVuX25hbWUiOiJTdGVsaW9zIiwiZW1haWxzIjpbInNnZXJvZ2lhQGdtYWlsLmNvbSJdLCJ0ZnAiOiJCMkNfMV9CbHVlQmFua1NVU0kifQ.0IltRHyRldhzkH5qQ3pS7HeuLgwS8XCi_3p9n2e5B_OvodTblZRYED1mKOnibA66I-tIFuwa0Ndxce3zxW22jrg3hvIszaaGdrf8OWKMhemgwm5cjLKfZj4_EBihlhly2DjwSBU02AkBqf3eeoiS-ArQ45d0Y5HsvrI06oWt01lBB-zPCRlys0lN1KlxSZNB1TKD1Wv9wTHVenjTrJCPa0S8ONIVgEtSPx_DeVXRku1ynioyIChmOCMwr6mcgTeXWXuLqw5fhiFkxa6NJnUV4pYSM86Nc3ZiIhB6q2eC2P_kkgitsRmiXcGMSgIE9XC0-Qbr5StiJiwVrK1ZBUNUDQ";

    private BlueBankService service = new BlueBankService();

    @Test
    public void shouldFetchCustomer() {
        Customer cust = service.getCustomer(TOKEN);

        assertThat(cust.givenName(), is("Stelios"));
    }

    @Test
    public void shouldFetchAccounts() {
        // arrange
        Customer cust = service.getCustomer(TOKEN);

        // act
        List<Account> accounts = service.getAccounts(cust.id(), TOKEN);

        // assert
        assertThat(accounts.size(), is(3));
        assertThat(accounts.get(0).accountBalance(), is(new BigDecimal("276.95")));
    }

    @Test
    public void shouldFetchTransactions() {
        // arrange
        Customer cust = service.getCustomer(TOKEN);
        Account acc = service.getAccounts(cust.id(), TOKEN).get(0);

        // act
        List<Transaction> transactions = service.getTransactions(acc.id(), TOKEN);

        // assert
        assertThat(transactions.size(), is(147));
        assertThat(transactions.get(0).amount(), is(new BigDecimal("5890.23")));
    }

    @Test
    public void shouldSortByMonthPositive() {
        // arrange
        List<Transaction> transactions = Lists.newArrayList(
                new Transaction().amount(new BigDecimal("10")).timestamp("2017-02-18T11:02:48.979Z"),
                new Transaction().amount(new BigDecimal("20")).timestamp("2017-02-19T11:02:48.979Z"),
                new Transaction().amount(new BigDecimal("10")).timestamp("2017-01-19T11:02:48.979Z"),
                new Transaction().amount(new BigDecimal("-20")).timestamp("2017-02-19T11:02:48.979Z")
        );
        // act
        Map<String, BigDecimal> results = service.sortByMonth(transactions, true);

        // assert
        assertThat(results.size(), is(2));
        assertThat(results.get("2017-2"), is(new BigDecimal("30")));
    }

    @Test
    public void shouldSortByMonthNegative() {
        // arrange
        List<Transaction> transactions = Lists.newArrayList(
                new Transaction().amount(new BigDecimal("-10")).timestamp("2017-02-18T11:02:48.979Z"),
                new Transaction().amount(new BigDecimal("20")).timestamp("2017-02-19T11:02:48.979Z"),
                new Transaction().amount(new BigDecimal("-10")).timestamp("2017-01-19T11:02:48.979Z"),
                new Transaction().amount(new BigDecimal("-20")).timestamp("2017-02-19T11:02:48.979Z")
        );
        // act
        Map<String, BigDecimal> results = service.sortByMonth(transactions, false);

        // assert
        assertThat(results.size(), is(2));
        assertThat(results.get("2017-2"), is(new BigDecimal("-30")));
    }

}
