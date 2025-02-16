package com.kata.sgbank.katasgbank.models.dtos;


import com.kata.sgbank.katasgbank.models.validators.ValidAccountId;
import jakarta.validation.constraints.NotNull;

public class DepositDto {

    @NotNull(message = "The accountIs is mandatory")
    @ValidAccountId(min = 2, max = 20, message = "accountId must contain between 2 and 20 characters")
    private Long accountId;
    @NotNull(message = "The amount is mandatory")
    private double amount;
    private String description;

    public DepositDto() {
    }

    public DepositDto(Long accountId, double amount, String description) {
        this.accountId = accountId;
        this.amount = amount;
        this.description = description;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DepositDto{");
        sb.append("accountId=").append(accountId);
        sb.append(", amount=").append(amount);
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
