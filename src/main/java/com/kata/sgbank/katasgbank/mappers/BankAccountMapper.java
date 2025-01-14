package com.kata.sgbank.katasgbank.mappers;

import com.kata.sgbank.katasgbank.models.dtos.AccountOperationDto;
import com.kata.sgbank.katasgbank.models.dtos.AccountDto;
import com.kata.sgbank.katasgbank.models.entities.AccountOperationEntity;
import com.kata.sgbank.katasgbank.models.entities.AccountEntity;

public interface BankAccountMapper {

    AccountDto fromBankAccountEntityToDto(AccountEntity accountEntity);

    AccountOperationEntity fromBankAccountDtoToEntity(AccountOperationDto accountOperationDto);

    AccountOperationDto fromAccountOperationEntityToDto(AccountOperationEntity accountOperationEntity);

    AccountOperationEntity fromAccountOperationDtoToEntity(AccountOperationDto accountOperationDto);

}
