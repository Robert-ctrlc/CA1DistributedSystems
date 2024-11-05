package com.example.dit.dto;

public class LoanDTO {
    private Long id;
    private String description;
    private Double loanAmount;

    public LoanDTO() {}

    public LoanDTO(Long id, String description, Double loanAmount) {
        this.id = id;
        this.description = description;
        this.loanAmount = loanAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Double loanAmount) {
        this.loanAmount = loanAmount;
    }
}
