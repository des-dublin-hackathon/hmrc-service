package com.rbs.hackaton.dublin.model;

public class EmploymentIncome {
    private String employerPayeReference;
    private Double payFromEmployment;

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
}
