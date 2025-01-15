package com.kata.sgbank.katasgbank;

import com.kata.sgbank.katasgbank.exceptionshandlers.SuspendedAccountException;
import com.kata.sgbank.katasgbank.models.dtos.AccountOperationDto;
import com.kata.sgbank.katasgbank.models.dtos.ResultAccountOperationsDto;
import com.kata.sgbank.katasgbank.services.AccountBankService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class AccountOperationsHistoryApplicationTest {

    @Autowired
    private AccountBankService accountBankService;

    @Test
    public void testSuspendedItShouldThrowSuspendedAccountException() {
        assertThrows(SuspendedAccountException.class,
                () -> accountBankService.accountOperationsHistory(3L));
    }

    @Test
    public void testlengthOfAccountOperationsEmptyByDefault() {
        ResultAccountOperationsDto resultAccountOperationsDto = accountBankService.accountOperationsHistory(1L);
        final List<AccountOperationDto> accountOperationDtos = resultAccountOperationsDto.getAccountOperations();
        assertTrue(accountOperationDtos.isEmpty());
    }


}
