package com.kata.sgbank.katasgbank.mappers;

import com.kata.sgbank.katasgbank.models.dtos.AccountOperationDto;
import com.kata.sgbank.katasgbank.models.dtos.BankAccountDto;
import com.kata.sgbank.katasgbank.models.entities.AccountOperationEntity;
import com.kata.sgbank.katasgbank.models.entities.BankAccountEntity;

public interface BankAccountMapper {

    BankAccountDto fromBankAccountEntityToDto(BankAccountEntity bankAccountEntity);

    AccountOperationEntity fromBankAccountDtoToEntity(AccountOperationDto accountOperationDto);

    AccountOperationDto fromAccountOperationEntityToDto(AccountOperationEntity accountOperationEntity);

    AccountOperationEntity fromAccountOperationDtoToEntity(AccountOperationDto accountOperationDto);

}
