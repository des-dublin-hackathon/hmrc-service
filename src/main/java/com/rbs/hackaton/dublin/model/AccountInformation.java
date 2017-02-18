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

    @JsonProperty("incomings")
    private Map<String, BigDecimal> monthlyIncomings;

    @JsonProperty("outgoings")
    private Map<String, BigDecimal>  monthlyOutgoings;
}
