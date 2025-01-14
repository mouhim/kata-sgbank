package com.kata.sgbank.katasgbank.services.impl;

import com.kata.sgbank.katasgbank.mappers.BankAccountMapper;
import com.kata.sgbank.katasgbank.services.AccountBankService;
import org.springframework.stereotype.Service;

@Service
public class AccountBankServiceImpl implements AccountBankService {

    private final BankAccountMapper bankAccountMapper;

    public AccountBankServiceImpl(BankAccountMapper bankAccountMapper) {
        this.bankAccountMapper = bankAccountMapper;
    }

}
