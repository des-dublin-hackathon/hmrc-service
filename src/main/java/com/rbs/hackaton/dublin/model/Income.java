package com.rbs.hackaton.dublin.model;

import java.util.ArrayList;
import java.util.List;

public class Income {

    private List<EmploymentIncome> employments = new ArrayList<>();
    private PensionBenefits pensionsAnnuitiesAndOtherStateBenefits = new PensionBenefits();

    public List<EmploymentIncome> getEmployments() {
        return employments;
    }

    public void setEmployments(List<EmploymentIncome> employments) {
        this.employments = employments;
    }

    public PensionBenefits getPensionsAnnuitiesAndOtherStateBenefits() {
        return pensionsAnnuitiesAndOtherStateBenefits;
    }

    public void setPensionsAnnuitiesAndOtherStateBenefits(PensionBenefits pensionsAnnuitiesAndOtherStateBenefits) {
        this.pensionsAnnuitiesAndOtherStateBenefits = pensionsAnnuitiesAndOtherStateBenefits;
    }
}
