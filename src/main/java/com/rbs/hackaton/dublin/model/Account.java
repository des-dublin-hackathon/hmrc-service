package com.rbs.hackaton.dublin.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@Accessors(fluent = true)
public class Account {

    @JsonProperty("id")
    private String id;
    @JsonProperty("sortCode")
    private String sortCode;
    @JsonProperty("accountNumber")
    private String accountNumber;
    @JsonProperty("accountBalance")
    private BigDecimal accountBalance;
}
