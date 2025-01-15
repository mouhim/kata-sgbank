package com.kata.sgbank.katasgbank.services.impl;

import com.kata.sgbank.katasgbank.exceptionshandlers.*;
import com.kata.sgbank.katasgbank.mappers.AccountMapper;
import com.kata.sgbank.katasgbank.models.dtos.*;
import com.kata.sgbank.katasgbank.models.entities.AccountEntity;
import com.kata.sgbank.katasgbank.models.entities.AccountOperationEntity;
import com.kata.sgbank.katasgbank.models.enums.AccountStatus;
import com.kata.sgbank.katasgbank.models.enums.OperationType;
import com.kata.sgbank.katasgbank.services.AccountBankService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.kata.sgbank.katasgbank.utils.CalculUtils.generateIdRandom;

@Service
@Slf4j
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

    private final AccountMapper accountMapper;

    public AccountBankServiceImpl(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    @Override
    public AccountDto deposit(final DepositDto depositDto) {

        log.info("Starting new deposit operation !");

        final Long accountId = depositDto.getAccountId();
        final double amount = depositDto.getAmount();
        final String description = depositDto.getDescription();

        validateCommonInputs(accountId, amount);

        final AccountEntity bankAccount = getAccountById(accountId).orElseThrow(() -> new AccountNotFoundException("BankAccount not found"));

        verifyIfAccountIsSuspended(bankAccount);

        final double newBalanceValue = bankAccount.getBalance() + amount;
        bankAccount.setBalance(newBalanceValue);

        final AccountOperationEntity accountOperation = buildAccountOperationEntity(OperationType.DEPOSIT, amount, newBalanceValue, description, bankAccount);

        bankAccount.getAccountOperations().add(accountOperation);

        log.info("The account with id : {} has been successfully credited", +accountId);
        return accountMapper.fromBankAccountEntityToDto(bankAccount);
    }

    @Override
    public AccountDto withdraw(final WithdrawDto withdrawDto) {

        log.info("Starting new withdraw operation !");

        final Long accountId = withdrawDto.getAccountId();
        final double amount = withdrawDto.getAmount();
        final String description = withdrawDto.getDescription();

        validateCommonInputs(accountId, amount);

        final AccountEntity bankAccount = getAccountById(accountId).orElseThrow(() -> new AccountNotFoundException("BankAccount not found"));

        verifyIfAccountIsSuspended(bankAccount);

        if (bankAccount.getBalance() < amount) throw new BalanceNotSufficientException("Balance not sufficient");

        final double newBalanceValue = bankAccount.getBalance() - amount;
        bankAccount.setBalance(newBalanceValue);

        final AccountOperationEntity accountOperation = buildAccountOperationEntity(OperationType.WITHDRAW, amount, newBalanceValue, description, bankAccount);

        bankAccount.getAccountOperations().add(accountOperation);

        log.info("The account with id : {} has been successfully debited", +accountId);

        return accountMapper.fromBankAccountEntityToDto(bankAccount);
    }

    private static void verifyIfAccountIsSuspended(AccountEntity bankAccount) {
        if (AccountStatus.SUSPENDED.equals(bankAccount.getStatus()))
            throw new SuspendedAccountException("Your bank account is suspended no operations will be allowed");
    }

    private static AccountOperationEntity buildAccountOperationEntity(OperationType withdraw, double amount,
                                                                      double newBalanceValue, String description, AccountEntity bankAccount) {
        final AccountOperationEntity accountOperation = new AccountOperationEntity();
        accountOperation.setId(generateIdRandom());
        accountOperation.setType(withdraw);
        accountOperation.setAmount(amount);
        accountOperation.setDescription(description);
        accountOperation.setOperationDate(new Date());
        accountOperation.setBankAccount(bankAccount);
        return accountOperation;
    }

    @Override
    public ResultAccountOperationsDto accountOperationsHistory(final Long accountId) {

        log.info("Start getting account operations history!");

        if (accountId == null) throw new UnknownAccountIdException("The accountId should not be unknown");

        final AccountEntity bankAccount = getAccountById(accountId).orElseThrow(() -> new AccountNotFoundException("BankAccount not found"));

        final List<AccountOperationEntity> accountOperations = getAccountOperationsHistoryBId(bankAccount);

        log.info("Finish getting account operations !");

        final List<AccountOperationDto> accountOperationDtosList = accountOperations.stream().map(accountMapper::fromAccountOperationEntityToDto).collect(Collectors.toList());
        return accountMapper.resultAccountOperationsDtoMapper(bankAccount, accountOperationDtosList);
    }

    private List<AccountOperationEntity> getAccountOperationsHistoryBId(final AccountEntity bankAccount) {

        verifyIfAccountIsSuspended(bankAccount);

        final List<AccountOperationEntity> accountOperations = bankAccount.getAccountOperations();

        return accountOperations != null && !accountOperations.isEmpty() ? accountOperations : new ArrayList<>();
    }

    private void validateCommonInputs(final Long accountId, final double amount) {

        if (accountId == null) throw new UnknownAccountIdException("The accountId should not be unknown");

        if (amount <= 0) throw new InvalidAmountException("The amount must be greater than zero");

    }

    private static Optional<AccountEntity> getAccountById(final Long accountId) {
        return accountsList.stream().filter(account -> accountId == account.getId()).findFirst();
    }

}
