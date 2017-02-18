package com.rbs.hackaton.dublin.service;

import com.google.common.collect.Lists;
import com.rbs.hackaton.dublin.model.Account;
import com.rbs.hackaton.dublin.model.AccountInformation;
import com.rbs.hackaton.dublin.model.Customer;
import com.rbs.hackaton.dublin.model.Transaction;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BlueBankServiceTest {

    private final String TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6ImdmSUtJSC15WjNwaFJIUnlqbnNISXFaTWFlUExHQUVMelBhdDBDTlk0c0EifQ.eyJleHAiOjE0ODc0NDYxMDUsIm5iZiI6MTQ4NzQ0MjUwNSwidmVyIjoiMS4wIiwiaXNzIjoiaHR0cHM6Ly9sb2dpbi5taWNyb3NvZnRvbmxpbmUuY29tL2Q1Zjg1NjgyLWY2N2EtNDQ0NC05MzY5LTJjNWVjMWEwZThjZC92Mi4wLyIsInN1YiI6ImE5MzE0M2ExLTJjYjQtNDIwNS1hNjgxLTNkNzJmZTcxNjI4ZCIsImF1ZCI6IjBmN2VmODEwLTJmOWMtNDI0Yy05NDJhLTQ4YzZlYTM2MWQ5YSIsIm5vbmNlIjoiZGVmYXVsdE5vbmNlIiwiaWF0IjoxNDg3NDQyNTA1LCJhdXRoX3RpbWUiOjE0ODc0NDI1MDUsIm9pZCI6ImE5MzE0M2ExLTJjYjQtNDIwNS1hNjgxLTNkNzJmZTcxNjI4ZCIsIm5hbWUiOiJzZ2Vyb2dpYSIsImZhbWlseV9uYW1lIjoiR2Vyb2dpYW5uYWtpcyIsImdpdmVuX25hbWUiOiJTdGVsaW9zIiwiZW1haWxzIjpbInNnZXJvZ2lhQGdtYWlsLmNvbSJdLCJ0ZnAiOiJCMkNfMV9CbHVlQmFua1NVU0kifQ.L_bA0tM8MYZlNuDjZYYnqcWitFjbV_xp37BJlIjh1_gNQBBQ755I5UVuFASdr44a1Mmk-5auu0rIuX8g6aT-EeG0o-xSLDW0B6OqVK9zl5uCKCe0AlmFvYEksMwcHffRog4KubHsELf4Xhqr2WIGS7VsyT1dirEdA6211SrNl2OL1-_J_GUp6vsB9HPLuv9_fwrUsyd-GYXa3-_vhdJn2-LI6tIq4daTShH95CLuDNixKi6l8KXaJOR5wZE9klz20aJcDl8LRPURC4fk-vw1FV7ogg2MsYYUaa0tm4N3HTg0ttQg1gGb1TS5WXVBxIvQrIhGIQeWaahLEViZtjJfnw";

    private BlueBankService service = new BlueBankService();

    @Test
    public void shouldFetchCustomer() {
        Customer cust = service.getCustomer(TOKEN);

        assertThat(cust.getGivenName(), is("Stelios"));
    }

    @Test
    public void shouldFetchAccounts() {
        // arrange
        Customer cust = service.getCustomer(TOKEN);

        // act
        List<Account> accounts = service.getAccounts(cust.getId(), TOKEN);

        // assert
        assertThat(accounts.size(), is(3));
        assertThat(accounts.get(0).accountBalance(), is(new BigDecimal("276.95")));
    }

    @Test
    public void shouldFetchTransactions() {
        // arrange
        Customer cust = service.getCustomer(TOKEN);
        Account acc = service.getAccounts(cust.getId(), TOKEN).get(0);

        // act
        List<Transaction> transactions = service.getTransactions(acc.id(), TOKEN);

        // assert
        assertThat(transactions.size(), is(147));
        assertThat(transactions.get(0).amount(), is(new BigDecimal("5890.23")));
    }

    @Test
    public void shouldSortByMonth() {
        // arrange
        List<Transaction> transactions = Lists.newArrayList(
                new Transaction().amount(new BigDecimal("10")).timestamp("2017-02-18T11:02:48.979Z"),
                new Transaction().amount(new BigDecimal("20")).timestamp("2017-02-19T11:02:48.979Z"),
                new Transaction().amount(new BigDecimal("10")).timestamp("2017-01-19T11:02:48.979Z"),
                new Transaction().amount(new BigDecimal("-20")).timestamp("2017-02-19T11:02:48.979Z"),
                new Transaction().amount(new BigDecimal("-20")).timestamp("2017-03-19T11:02:48.979Z")
        );
        // act
        Map<String, AccountInformation.Pair> results = service.sortByMonth(transactions);

        // assert
        assertThat(results.size(), is(3));
        assertThat(results.get("2017-1"), is(new AccountInformation.Pair()
                .incomings(new BigDecimal("10"))
                .outgoings(BigDecimal.ZERO)));
        assertThat(results.get("2017-2"), is(new AccountInformation.Pair()
                .incomings(new BigDecimal("30"))
                .outgoings(new BigDecimal("-20"))));
        assertThat(results.get("2017-3"), is(new AccountInformation.Pair()
                .incomings(BigDecimal.ZERO)
                .outgoings(new BigDecimal("-20"))));
    }
}
