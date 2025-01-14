package com.kata.sgbank.katasgbank.models.entities;

import com.kata.sgbank.katasgbank.models.enums.AccountStatus;

import java.util.Date;
import java.util.List;


public class AccountEntity {

    private Long id;
    private double balance;
    private Date createdAt;
    private AccountStatus status;
    private List<AccountOperationEntity> accountOperations;


    public AccountEntity() {
    }

    public AccountEntity(Long id, double balance, Date createdAt, AccountStatus status, List<AccountOperationEntity> accountOperations) {
        this.id = id;
        this.balance = balance;
        this.createdAt = createdAt;
        this.status = status;
        this.accountOperations = accountOperations;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BankAccountEntity{");
        sb.append("id=").append(id);
        sb.append(", balance=").append(balance);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", status=").append(status);
        sb.append(", accountOperations=").append(accountOperations);
        sb.append('}');
        return sb.toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public List<AccountOperationEntity> getAccountOperations() {
        return accountOperations;
    }

    public void setAccountOperations(List<AccountOperationEntity> accountOperations) {
        this.accountOperations = accountOperations;
    }
}
