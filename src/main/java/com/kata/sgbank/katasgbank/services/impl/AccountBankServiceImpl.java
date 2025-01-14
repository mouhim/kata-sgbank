package com.kata.sgbank.katasgbank.services.impl;

import com.kata.sgbank.katasgbank.exceptionshandlers.*;
import com.kata.sgbank.katasgbank.mappers.BankAccountMapper;
import com.kata.sgbank.katasgbank.models.dtos.AccountDto;
import com.kata.sgbank.katasgbank.models.dtos.DepositDto;
import com.kata.sgbank.katasgbank.models.dtos.WithdrawDto;
import com.kata.sgbank.katasgbank.models.entities.AccountEntity;
import com.kata.sgbank.katasgbank.models.entities.AccountOperationEntity;
import com.kata.sgbank.katasgbank.models.enums.AccountStatus;
import com.kata.sgbank.katasgbank.models.enums.OperationType;
import com.kata.sgbank.katasgbank.services.AccountBankService;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.kata.sgbank.katasgbank.utils.CalculUtils.generateIdRandom;

@Service
public class AccountBankServiceImpl implements AccountBankService {

    private static List<AccountEntity> accountsList = new ArrayList<>();

    static {
        // Without JpaRepository interface, i will initialize the list here
        final AccountEntity account1 = new AccountEntity();
        account1.setId(1L);
        account1.setBalance(10000);
        account1.setCreatedAt(new Date());
        account1.setStatus(AccountStatus.ACTIVATED);
        account1.setAccountOperations(new ArrayList<>());

        final AccountEntity account2 = new AccountEntity();
        account2.setId(2L);
        account2.setBalance(15000);
        account2.setCreatedAt(new Date());
        account2.setStatus(AccountStatus.ACTIVATED);
        account2.setAccountOperations(new ArrayList<>());

        final AccountEntity account3 = new AccountEntity();
        account3.setId(3L);
        account3.setBalance(4000);
        account3.setCreatedAt(new Date());
        account3.setStatus(AccountStatus.SUSPENDED);
        account3.setAccountOperations(new ArrayList<>());

        AccountBankServiceImpl.accountsList = List.of(account1, account2, account3);
    }

    private final BankAccountMapper bankAccountMapper;

    public AccountBankServiceImpl(BankAccountMapper bankAccountMapper) {
        this.bankAccountMapper = bankAccountMapper;
    }

    @Override
    public AccountDto deposit(final DepositDto depositDto) {

        final Long accountId = depositDto.getAccountId();
        final double amount = depositDto.getAmount();
        final String description = depositDto.getDescription();

        validateCommonInputs(accountId, amount);

        final AccountEntity bankAccount = getAccountById(accountId).orElseThrow(() -> new AccountNotFoundException("BankAccount not found"));

        if (AccountStatus.SUSPENDED.equals(bankAccount.getStatus()))
            throw new SuspendedAccountException("Your bank account is suspended no operations will be allowed");

        double newBalanceValue = bankAccount.getBalance() + amount;
        bankAccount.setBalance(newBalanceValue);

        final AccountOperationEntity accountOperation = new AccountOperationEntity();
        accountOperation.setId(generateIdRandom());
        accountOperation.setType(OperationType.DEPOSIT);
        accountOperation.setAmount(amount);
        accountOperation.setDescription(description);
        accountOperation.setOperationDate(new Date());
        accountOperation.setBankAccount(bankAccount);

        bankAccount.getAccountOperations().add(accountOperation);

        return bankAccountMapper.fromBankAccountEntityToDto(bankAccount);
    }

    @Override
    public AccountDto withdraw(final WithdrawDto withdrawDto) {

        final Long accountId = withdrawDto.getAccountId();
        final double amount = withdrawDto.getAmount();
        final String description = withdrawDto.getDescription();

        validateCommonInputs(accountId, amount);

        final AccountEntity bankAccount = getAccountById(accountId)
                .orElseThrow(() -> new AccountNotFoundException("BankAccount not found"));

        if (AccountStatus.SUSPENDED.equals(bankAccount.getStatus()))
            throw new SuspendedAccountException("Your bank account is suspended no operations will be allowed");

        if (bankAccount.getBalance() < amount)
            throw new BalanceNotSufficientException("Balance not sufficient");

        AccountOperationEntity accountOperation = new AccountOperationEntity();
        accountOperation.setType(OperationType.WITHDRAW);
        accountOperation.setAmount(amount);
        accountOperation.setDescription(description);
        accountOperation.setOperationDate(new Date());
        accountOperation.setBankAccount(bankAccount);

        bankAccount.getAccountOperations().add(accountOperation);

        double newBalanceValue = bankAccount.getBalance() - amount;
        bankAccount.setBalance(newBalanceValue);

        return bankAccountMapper.fromBankAccountEntityToDto(bankAccount);
    }

    private void validateCommonInputs(final Long accountId, final double amount) {

        if (accountId == null) throw new UnknownAccountIdException("The accountId should not be unknown");

        if (amount <= 0) throw new InvalidAmountException("The amount must be greater than zero");

    }

    private static Optional<AccountEntity> getAccountById(Long accountId) {
        return accountsList.stream().filter(account -> Objects.equals(accountId, account.getId())).findFirst();
    }

}
