package com.kata.sgbank.katasgbank;

import com.kata.sgbank.katasgbank.exceptionshandlers.InvalidAmountException;
import com.kata.sgbank.katasgbank.exceptionshandlers.SuspendedAccountException;
import com.kata.sgbank.katasgbank.exceptionshandlers.UnknownAccountIdException;
import com.kata.sgbank.katasgbank.models.dtos.AccountDto;
import com.kata.sgbank.katasgbank.models.dtos.DepositDto;
import com.kata.sgbank.katasgbank.services.AccountBankService;
import com.kata.sgbank.katasgbank.utils.JsonsUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class DepositApplicationTest {

    @Autowired
    private AccountBankService accountBankService;

    private DepositDto depositDto;

    @BeforeEach
    public void setUp() {
        depositDto = new DepositDto(11L, 150, "déposer 150 dans mon compte");
    }

    // Méthode pour fournir les paires de fichiers JSON (requête et réponse)
    public static Stream<Arguments> provideJsonFiles() {
        // Ici, nous parcourons les dossiers requests et responses pour charger les paires de fichiers
        return Stream.of(
                Arguments.of("Deposit1_in.json", "Deposit1_out.json"),
                Arguments.of("Deposit2_in.json", "Deposit2_out.json"),
                Arguments.of("Deposit3_in.json", "Deposit3_out.json"),
                Arguments.of("Deposit4_in.json", "Deposit4_out.json"),
                Arguments.of("Deposit5_in.json", "Deposit5_out.json"));
    }

    @DisplayName("Tests Paramétrés")
    @ParameterizedTest
    @MethodSource("provideJsonFiles")
    public void testDepositApplyManyOperationsInOneAccountWithJson(String requestFileName, String responseFileName) throws IOException {
        // Load requests JSON (Deposit5_in.json)
        final String requestJson = JsonsUtils.loadJsonFile("parameterizedTests/deposit/requests/" + requestFileName);

        final DepositDto requestDepositDto = JsonsUtils.strJsonToDepositDto(requestJson);
        AccountDto accountDto = accountBankService.deposit(requestDepositDto);
        // Load responses JSON (Deposit5_out.json)
        String expectedJsonResponse = JsonsUtils.loadJsonFile("parameterizedTests/deposit/responses/" + responseFileName).trim();
        AccountDto expectedAccountDto = JsonsUtils.strJsonToAccountDto(expectedJsonResponse);

        Assertions.assertEquals(accountDto.getBalance(), expectedAccountDto.getBalance());
    }

    @Test
    public void testItShouldThrowInvalidAmountException() {
        depositDto.setAmount(-100);
        assertThrows(InvalidAmountException.class, () -> accountBankService.deposit(depositDto));
    }

    @Test
    public void testItShouldThrowSuspendedAccountException() {
        depositDto.setAccountId(13L);
        assertThrows(SuspendedAccountException.class, () -> accountBankService.deposit(depositDto));
    }

    @Test
    public void testItShouldThrowUnknownAccountIdException() {
        depositDto.setAccountId(null);
        assertThrows(UnknownAccountIdException.class, () -> accountBankService.deposit(depositDto));
    }

    @Test
    public void testAmountZeroItShouldThrowInvalidAmountException() {
        depositDto.setAmount(0);
        assertThrows(InvalidAmountException.class, () -> accountBankService.deposit(depositDto));
    }

}
