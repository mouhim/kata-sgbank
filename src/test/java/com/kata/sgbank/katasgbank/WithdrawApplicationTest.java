package com.kata.sgbank.katasgbank;

import com.kata.sgbank.katasgbank.exceptionshandlers.BalanceNotSufficientException;
import com.kata.sgbank.katasgbank.exceptionshandlers.InvalidAmountException;
import com.kata.sgbank.katasgbank.exceptionshandlers.SuspendedAccountException;
import com.kata.sgbank.katasgbank.exceptionshandlers.UnknownAccountIdException;
import com.kata.sgbank.katasgbank.models.dtos.AccountDto;
import com.kata.sgbank.katasgbank.models.dtos.WithdrawDto;
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
class WithdrawApplicationTest {

    @Autowired
    private AccountBankService accountBankService;

    private WithdrawDto withdrawDto;

    @BeforeEach
    public void setUp() {
        withdrawDto = new WithdrawDto(1L, 120000, "retirer 12000 de mon compte");
    }

    // Méthode pour fournir les paires de fichiers JSON (requête et réponse)
    public static Stream<Arguments> provideJsonFiles() {
        // Ici, nous parcourons les dossiers requests et responses pour charger les paires de fichiers
        return Stream.of(
                Arguments.of("Withdraw1_in.json", "Withdraw1_out.json"),
                Arguments.of("Withdraw2_in.json", "Withdraw2_out.json"),
                Arguments.of("Withdraw3_in.json", "Withdraw3_out.json"),
                Arguments.of("Withdraw4_in.json", "Withdraw4_out.json"),
                Arguments.of("Withdraw5_in.json", "Withdraw5_out.json"));
    }

    @DisplayName("Tests Paramétrés")
    @ParameterizedTest
    @MethodSource("provideJsonFiles")
    public void testWithdrawApplyManyOperationsInOneAccountWithJson(String requestFileName, String responseFileName) throws IOException {
        // Load requests JSON (Withdraw5_in.json)
        final String requestJson = JsonsUtils.loadJsonFile("parameterizedTests/withdraw/requests/" + requestFileName);

        final WithdrawDto requestWithdrawDto = JsonsUtils.strJsonToWithdrawDto(requestJson);
        AccountDto accountDto = accountBankService.withdraw(requestWithdrawDto);
        // Load responses JSON (Withdraw5_out.json)
        final String expectedJsonResponse = JsonsUtils.loadJsonFile("parameterizedTests/withdraw/responses/" + responseFileName).trim();
        final AccountDto expectedAccountDto = JsonsUtils.strJsonToAccountDto(expectedJsonResponse);

        Assertions.assertEquals(accountDto.getBalance(), expectedAccountDto.getBalance());
    }

    @Test
    public void testItShouldThrowBalanceNotSufficientException() {
        assertThrows(BalanceNotSufficientException.class,
                () -> accountBankService.withdraw(withdrawDto));
    }

    @Test
    public void testItShouldThrowInvalidAmountException() {
        withdrawDto.setAmount(-400);
        assertThrows(InvalidAmountException.class,
                () -> accountBankService.withdraw(withdrawDto));
    }

    @Test
    public void testItShouldThrowSuspendedAccountException() {
        withdrawDto.setAccountId(3L);
        assertThrows(SuspendedAccountException.class,
                () -> accountBankService.withdraw(withdrawDto));
    }

    @Test
    public void testItShouldThrowUnknownAccountIdException() {
        withdrawDto.setAccountId(null);
        assertThrows(UnknownAccountIdException.class,
                () -> accountBankService.withdraw(withdrawDto));
    }

    @Test
    public void testAmountZeroItShouldThrowInvalidAmountException() {
        withdrawDto.setAmount(0);
        assertThrows(InvalidAmountException.class,
                () -> accountBankService.withdraw(withdrawDto));
    }

}
