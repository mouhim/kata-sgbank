package com.kata.sgbank.katasgbank.mappers;

import com.kata.sgbank.katasgbank.models.dtos.AccountOperationDto;
import com.kata.sgbank.katasgbank.models.dtos.BankAccountDto;
import com.kata.sgbank.katasgbank.models.entities.AccountOperationEntity;
import com.kata.sgbank.katasgbank.models.entities.BankAccountEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class BankAccountMapperImpl implements BankAccountMapper {

    @Override
    public BankAccountDto fromBankAccountEntityToDto(BankAccountEntity bankAccountEntity) {
        final BankAccountDto bankAccountDto = new BankAccountDto();
        BeanUtils.copyProperties(bankAccountEntity, bankAccountDto);
        return bankAccountDto;
    }

    @Override
    public AccountOperationEntity fromBankAccountDtoToEntity(AccountOperationDto accountOperationDto) {
        final AccountOperationEntity accountOperationEntity = new AccountOperationEntity();
        BeanUtils.copyProperties(accountOperationDto, accountOperationEntity);
        return accountOperationEntity;
    }

    @Override
    public AccountOperationDto fromAccountOperationEntityToDto(AccountOperationEntity accountOperationEntity) {
        final AccountOperationDto accountOperationDto = new AccountOperationDto();
        BeanUtils.copyProperties(accountOperationEntity, accountOperationDto);
        return accountOperationDto;
    }

    @Override
    public AccountOperationEntity fromAccountOperationDtoToEntity(AccountOperationDto accountOperationDto) {
        final AccountOperationEntity accountOperationEntity = new AccountOperationEntity();
        BeanUtils.copyProperties(accountOperationDto, accountOperationEntity);
        return accountOperationEntity;
    }

}