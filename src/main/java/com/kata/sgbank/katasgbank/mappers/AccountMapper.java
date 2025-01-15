package com.kata.sgbank.katasgbank.mappers;

import com.kata.sgbank.katasgbank.models.dtos.AccountDto;
import com.kata.sgbank.katasgbank.models.dtos.AccountOperationDto;
import com.kata.sgbank.katasgbank.models.dtos.ResultAccountOperationsDto;
import com.kata.sgbank.katasgbank.models.entities.AccountEntity;
import com.kata.sgbank.katasgbank.models.entities.AccountOperationEntity;

import java.util.List;

public interface AccountMapper {

    AccountDto fromBankAccountEntityToDto(final AccountEntity accountEntity);

    AccountEntity fromBankAccountDtoToEntity(final AccountDto accountDto);

    AccountOperationDto fromAccountOperationEntityToDto(final AccountOperationEntity accountOperationEntity);

    AccountOperationEntity fromAccountOperationDtoToEntity(final AccountOperationDto accountOperationDto);

    ResultAccountOperationsDto resultAccountOperationsDtoMapper(final AccountEntity bankAccount, final List<AccountOperationDto> accountOperationDtosList);
}
