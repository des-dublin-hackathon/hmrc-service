package com.rbs.hackaton.dublin.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@Accessors(fluent = true)
public class Transaction {

    @JsonProperty("transactionDateTime")
    private String timestamp;
    @JsonProperty("transactionAmount")
    private BigDecimal amount;
}
