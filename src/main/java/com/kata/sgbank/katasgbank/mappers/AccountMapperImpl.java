package com.kata.sgbank.katasgbank.mappers;

import com.kata.sgbank.katasgbank.exceptionshandlers.AccountIsNullException;
import com.kata.sgbank.katasgbank.exceptionshandlers.AccountNotFoundException;
import com.kata.sgbank.katasgbank.exceptionshandlers.AccountOperationIsNullException;
import com.kata.sgbank.katasgbank.models.dtos.AccountDto;
import com.kata.sgbank.katasgbank.models.dtos.AccountOperationDto;
import com.kata.sgbank.katasgbank.models.dtos.ResultAccountOperationsDto;
import com.kata.sgbank.katasgbank.models.entities.AccountEntity;
import com.kata.sgbank.katasgbank.models.entities.AccountOperationEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AccountMapperImpl implements AccountMapper {

    @Override
    public AccountDto fromBankAccountEntityToDto(final AccountEntity accountEntity) {
        if (accountEntity == null) {
            log.error("Account entity is unknown");
            throw new AccountIsNullException("Account entity is unknown");
        }
        final AccountDto accountDto = new AccountDto();
        BeanUtils.copyProperties(accountEntity, accountDto);
        return accountDto;
    }

    @Override
    public AccountEntity fromBankAccountDtoToEntity(final AccountDto accountDto) {
        if (accountDto == null) {
            log.error("Account dto is unknown");
            throw new AccountIsNullException("Account dto is unknown");
        }
        final AccountEntity accountEntity = new AccountEntity();
        BeanUtils.copyProperties(accountDto, accountEntity);
        return accountEntity;
    }

    @Override
    public AccountOperationDto fromAccountOperationEntityToDto(final AccountOperationEntity accountOperationEntity) {
        if (accountOperationEntity == null) {
            log.error("Account operation entity is unknown");
            throw new AccountOperationIsNullException("Account operation entity is unknown");
        }

        final AccountOperationDto accountOperationDto = new AccountOperationDto();
        BeanUtils.copyProperties(accountOperationEntity, accountOperationDto);

        return accountOperationDto;
    }

    @Override
    public AccountOperationEntity fromAccountOperationDtoToEntity(final AccountOperationDto accountOperationDto) {
        if (accountOperationDto == null) {
            log.error("Account operation dto is unknown");
            throw new AccountOperationIsNullException("Account operation dto is unknown");
        }

        final AccountOperationEntity accountOperationEntity = new AccountOperationEntity();
        BeanUtils.copyProperties(accountOperationDto, accountOperationEntity);
        return accountOperationEntity;
    }

    @Override
    public ResultAccountOperationsDto resultAccountOperationsDtoMapper(final AccountEntity bankAccount, final List<AccountOperationDto> accountOperationDtosList) {
        if (bankAccount == null) {
            log.error("Bank Account is unknown");
            throw new AccountIsNullException("Bank Account is unknown");
        }

        if (accountOperationDtosList == null) {
            log.error("Account Operations are unknown");
            throw new AccountOperationIsNullException("Account Operations are unknown");
        }

        final ResultAccountOperationsDto resultAccountOperationsDto = new ResultAccountOperationsDto();
        resultAccountOperationsDto.setAccountId(bankAccount.getId());
        resultAccountOperationsDto.setBalance(bankAccount.getBalance());
        resultAccountOperationsDto.setStatus(bankAccount.getStatus());
        resultAccountOperationsDto.setAccountOperations(accountOperationDtosList);
        return resultAccountOperationsDto;
    }

}