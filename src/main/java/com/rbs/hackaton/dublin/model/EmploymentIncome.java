package com.rbs.hackaton.dublin.model;

public class EmploymentIncome {
    private String employerPayeReference;
    private Double payFromEmployment;
    private String name;

    public String getEmployerPayeReference() {
        return employerPayeReference;
    }

    public void setEmployerPayeReference(String employerPayeReference) {
        this.employerPayeReference = employerPayeReference;
    }

    public Double getPayFromEmployment() {
        return payFromEmployment;
    }

    public void setPayFromEmployment(Double payFromEmployment) {
        this.payFromEmployment = payFromEmployment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
