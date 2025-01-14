package com.kata.sgbank.katasgbank.models.entities;

import com.kata.sgbank.katasgbank.models.enums.OperationType;

import java.util.Date;

public class AccountOperationEntity {

    private Long id;
    private Date operationDate;
    private double amount;
    private OperationType type;
    private AccountEntity bankAccount;
    private String description;

    public AccountOperationEntity() {
    }

    public AccountOperationEntity(Long id, Date operationDate, double amount, OperationType type, AccountEntity bankAccount, String description) {
        this.id = id;
        this.operationDate = operationDate;
        this.amount = amount;
        this.type = type;
        this.bankAccount = bankAccount;
        this.description = description;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AccountOperationEntity{");
        sb.append("id=").append(id);
        sb.append(", operationDate=").append(operationDate);
        sb.append(", amount=").append(amount);
        sb.append(", type=").append(type);
        sb.append(", bankAccount=").append(bankAccount);
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

    public AccountEntity getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(AccountEntity bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
