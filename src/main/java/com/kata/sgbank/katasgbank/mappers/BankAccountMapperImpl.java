package com.kata.sgbank.katasgbank.mappers;

import com.kata.sgbank.katasgbank.models.dtos.AccountOperationDto;
import com.kata.sgbank.katasgbank.models.dtos.AccountDto;
import com.kata.sgbank.katasgbank.models.entities.AccountOperationEntity;
import com.kata.sgbank.katasgbank.models.entities.AccountEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class BankAccountMapperImpl implements BankAccountMapper {

    @Override
    public AccountDto fromBankAccountEntityToDto(AccountEntity accountEntity) {
        final AccountDto accountDto = new AccountDto();
        BeanUtils.copyProperties(accountEntity, accountDto);
        return accountDto;
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