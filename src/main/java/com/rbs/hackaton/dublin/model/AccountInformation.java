package com.rbs.hackaton.dublin.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Map;

@Data
@Accessors(fluent = true)
public class AccountInformation {

    @JsonProperty("accountNumber")
    private String accountNumber;

    @JsonProperty("sortCode")
    private String sortCode;

    @JsonProperty("balance")
    private BigDecimal balance;

    @JsonProperty("sums")
    private Map<String, Pair> monthlySums;

    @Data
    @Accessors(fluent = true)
    public static class Pair {

        @JsonProperty("incomings")
        private BigDecimal incomings = BigDecimal.ZERO;
        @JsonProperty("outgoings")
        private BigDecimal outgoings = BigDecimal.ZERO;
    }
}
