package com.kata.sgbank.katasgbank.controllers;

import com.kata.sgbank.katasgbank.services.AccountBankService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kata")
public class BankAccountController {

    private final AccountBankService accountBankService;

    public BankAccountController(AccountBankService accountBankService) {
        this.accountBankService = accountBankService;
    }


}
