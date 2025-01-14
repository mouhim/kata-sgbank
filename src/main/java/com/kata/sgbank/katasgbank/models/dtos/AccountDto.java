package com.kata.sgbank.katasgbank.models.dtos;

import com.kata.sgbank.katasgbank.models.enums.AccountStatus;

import java.util.Date;

public class AccountDto {

    private Long id;
    private double balance;
    private Date createdAt;
    private AccountStatus status;

    public AccountDto() {
    }

    public AccountDto(Long id, double balance, Date createdAt, AccountStatus status) {
        this.id = id;
        this.balance = balance;
        this.createdAt = createdAt;
        this.status = status;
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
}
