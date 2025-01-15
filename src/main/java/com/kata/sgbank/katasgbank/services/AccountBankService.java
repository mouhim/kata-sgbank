package com.kata.sgbank.katasgbank.services;

import com.kata.sgbank.katasgbank.models.dtos.*;

import java.util.List;

public interface AccountBankService {

    AccountDto deposit(final DepositDto depositDto);

    AccountDto withdraw(final WithdrawDto withdrawDto);

    ResultAccountOperationsDto accountOperationsHistory(final Long accountId);

}
