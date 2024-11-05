package com.example.dit.dto;

public class DepositDTO {
    private Long id;
    private String depositDate;
    private Double amount;

    public DepositDTO() {}

    public DepositDTO(Long id, String depositDate, Double amount) {
        this.id = id;
        this.depositDate = depositDate;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepositDate() {
        return depositDate;
    }

    public void setDepositDate(String depositDate) {
        this.depositDate = depositDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
