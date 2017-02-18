package com.rbs.hackaton.dublin.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true)
public class Customer {

    @JsonProperty("id")
    private String id;
    @JsonProperty("givenName")
    private String givenName;
    @JsonProperty("familyName")
    private String familyName;
    @JsonProperty("address1")
    private String address1;
    @JsonProperty("postCode")
    private String postCode;
    @JsonProperty("mobilePhone")
    private String mobilePhone;
}
