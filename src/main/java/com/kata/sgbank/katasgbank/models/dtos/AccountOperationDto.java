package com.kata.sgbank.katasgbank.models.dtos;

import com.kata.sgbank.katasgbank.models.enums.OperationType;

import java.util.Date;

public class AccountOperationDto {
    private Long id;
    private Date operationDate;
    private double amount;
    private OperationType type;
    private String description;

    public AccountOperationDto() {
    }

    public AccountOperationDto(Long id, Date operationDate, double amount, OperationType type, String description) {
        this.id = id;
        this.operationDate = operationDate;
        this.amount = amount;
        this.type = type;
        this.description = description;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AccountOperationDto{");
        sb.append("id=").append(id);
        sb.append(", operationDate=").append(operationDate);
        sb.append(", amount=").append(amount);
        sb.append(", type=").append(type);
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public OperationType getType() {
        return type;
    }

    public void setType(OperationType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
