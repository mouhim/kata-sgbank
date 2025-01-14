package com.kata.sgbank.katasgbank.services;

import com.kata.sgbank.katasgbank.models.dtos.AccountDto;
import com.kata.sgbank.katasgbank.models.dtos.DepositDto;

public interface AccountBankService {

    AccountDto deposit(final DepositDto depositDto);

}
