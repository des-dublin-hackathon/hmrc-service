package com.rbs.hackaton.dublin.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(fluent = true)
public class CustomerResults {

    @JsonProperty("results")
    private List<Customer> results;
}
