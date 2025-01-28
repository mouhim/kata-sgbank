package com.kata.sgbank.katasgbank.controllers;

import com.kata.sgbank.katasgbank.exceptionshandlers.AccountNotFoundException;
import com.kata.sgbank.katasgbank.models.dtos.*;
import com.kata.sgbank.katasgbank.services.AccountBankService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/kata")
@Tag(name = "Kata SG Bank Account Operations", description = "Operations related to deposit, withdraw, get account operations history")
public class BankAccountController {

    private final AccountBankService accountBankService;

    public BankAccountController(AccountBankService accountBankService) {
        this.accountBankService = accountBankService;
    }

    @PostMapping("/accounts/deposit")
    @Operation(summary = "Deposit into a bank account", description = "Deposits a given amount into a given bank account")
    @Parameter(description = "accountId and amount", required = true)
    public ResponseEntity<AccountDto> deposit(@Valid @RequestBody DepositDto depositDto) throws AccountNotFoundException {
        final AccountDto accountDto = this.accountBankService.deposit(depositDto);
        return new ResponseEntity<>(accountDto, HttpStatus.OK);
    }

    @PostMapping("/accounts/withdraw")
    @Operation(summary = "Withdraw from a bank account", description = "Withdraws a given amount from a given bank account. If insufficient funds, returns an error")
    @Parameter(description = "accountId and amount", required = true)
    public ResponseEntity<AccountDto> withdraw(@Valid @RequestBody WithdrawDto withdrawDto) throws AccountNotFoundException {
        final AccountDto accountDto = this.accountBankService.withdraw(withdrawDto);
        return new ResponseEntity<>(accountDto, HttpStatus.OK);
    }

    @GetMapping("/accounts/{accountId}/operations")
    @Operation(summary = "Get account operations history", description = "Returns the history of operations for a given accountId")
    @Parameter(description = "accountId", required = true)
    public ResponseEntity<ResultAccountOperationsDto> getHistory(@PathVariable Long accountId) {
        final ResultAccountOperationsDto resultAccountOperationsDto = this.accountBankService.accountOperationsHistory(accountId);
        return new ResponseEntity<>(resultAccountOperationsDto, HttpStatus.OK);
    }

}
