package com.kata.sgbank.katasgbank.controllers;

import com.kata.sgbank.katasgbank.exceptionshandlers.AccountNotFoundException;
import com.kata.sgbank.katasgbank.models.dtos.AccountDto;
import com.kata.sgbank.katasgbank.models.dtos.DepositDto;
import com.kata.sgbank.katasgbank.services.AccountBankService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kata")
public class BankAccountController {

    private final AccountBankService accountBankService;

    public BankAccountController(AccountBankService accountBankService) {
        this.accountBankService = accountBankService;
    }

    @PostMapping("/accounts/deposit")
    public ResponseEntity<AccountDto> deposit(@RequestBody DepositDto depositDto) throws AccountNotFoundException {
        final AccountDto accountDto = this.accountBankService.deposit(depositDto);
        return new ResponseEntity<>(accountDto, HttpStatus.OK);
    }

}
