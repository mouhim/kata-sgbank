package com.kata.sgbank.katasgbank.services;

import com.kata.sgbank.katasgbank.models.dtos.AccountDto;
import com.kata.sgbank.katasgbank.models.dtos.AccountOperationDto;
import com.kata.sgbank.katasgbank.models.dtos.DepositDto;
import com.kata.sgbank.katasgbank.models.dtos.WithdrawDto;

import java.util.List;

public interface AccountBankService {

    AccountDto deposit(final DepositDto depositDto);

    AccountDto withdraw(final WithdrawDto withdrawDto);

    List<AccountOperationDto> accountOperationsHistory(final Long accountId);

}
