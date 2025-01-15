package com.kata.sgbank.katasgbank.exceptionshandlers;

import com.kata.sgbank.katasgbank.models.dtos.AccountErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<AccountErrorDto> handleAccountNotFoundException(AccountNotFoundException e) {
        final AccountErrorDto accountErrorDto = new AccountErrorDto();
        accountErrorDto.setCode(HttpStatus.NOT_FOUND.value());
        accountErrorDto.setMessage(e.getMessage());
        accountErrorDto.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<>(accountErrorDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BalanceNotSufficientException.class)
    public ResponseEntity<AccountErrorDto> handleBalanceNotSufficientException(BalanceNotSufficientException e) {
        final AccountErrorDto accountErrorDto = new AccountErrorDto();
        accountErrorDto.setCode(HttpStatus.BAD_REQUEST.value());
        accountErrorDto.setMessage(e.getMessage());
        accountErrorDto.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<>(accountErrorDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidAmountException.class)
    public ResponseEntity<AccountErrorDto> handleInvalidAmountException(InvalidAmountException e) {
        final AccountErrorDto accountErrorDto = new AccountErrorDto();
        accountErrorDto.setCode(HttpStatus.BAD_REQUEST.value());
        accountErrorDto.setMessage(e.getMessage());
        accountErrorDto.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<>(accountErrorDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SuspendedAccountException.class)
    public ResponseEntity<AccountErrorDto> handleSuspendedAccountException(SuspendedAccountException e) {
        final AccountErrorDto accountErrorDto = new AccountErrorDto();
        accountErrorDto.setCode(HttpStatus.FORBIDDEN.value());
        accountErrorDto.setMessage(e.getMessage());
        accountErrorDto.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<>(accountErrorDto, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(AccountOperationIsNullException.class)
    public ResponseEntity<AccountErrorDto> handleAccountOperationIsNullException(AccountOperationIsNullException e) {
        final AccountErrorDto accountErrorDto = new AccountErrorDto();
        accountErrorDto.setCode(HttpStatus.FORBIDDEN.value());
        accountErrorDto.setMessage(e.getMessage());
        accountErrorDto.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<>(accountErrorDto, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(AccountIsNullException.class)
    public ResponseEntity<AccountErrorDto> handleAccountIsNullException(AccountIsNullException e) {
        final AccountErrorDto accountErrorDto = new AccountErrorDto();
        accountErrorDto.setCode(HttpStatus.BAD_REQUEST.value());
        accountErrorDto.setMessage(e.getMessage());
        accountErrorDto.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<>(accountErrorDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<AccountErrorDto> handleProjectWebException(Exception e) {
        final AccountErrorDto accountErrorDto = new AccountErrorDto();
        accountErrorDto.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        accountErrorDto.setMessage(e.getMessage());
        accountErrorDto.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<>(accountErrorDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
