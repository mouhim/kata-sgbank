package com.kata.sgbank.katasgbank;

import com.kata.sgbank.katasgbank.exceptionshandlers.AccountIsNullException;
import com.kata.sgbank.katasgbank.mappers.AccountMapper;
import com.kata.sgbank.katasgbank.models.dtos.AccountDto;
import com.kata.sgbank.katasgbank.models.entities.AccountEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class AccountMapperTest {

    @Autowired
    private AccountMapper accountMapper;
    private AccountEntity accountEntity;
    private AccountDto accountDto;

    @BeforeEach
    public void setUp() {
        //accountEntity = new AccountEntity();
    }

    @Test
    public void testItShouldThrowAccountEntityIsNullException() {
        assertThrows(AccountIsNullException.class,
                () -> accountMapper.fromBankAccountEntityToDto(accountEntity));
    }

    @Test
    public void testItShouldThrowAccountDtoIsNullException() {
        assertThrows(AccountIsNullException.class,
                () -> accountMapper.fromBankAccountDtoToEntity(accountDto));
    }

}
