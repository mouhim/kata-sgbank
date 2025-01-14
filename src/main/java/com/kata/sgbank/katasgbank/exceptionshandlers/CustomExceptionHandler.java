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
        accountErrorDto.setCode(HttpStatus.NOT_ACCEPTABLE.value());
        accountErrorDto.setMessage(e.getMessage());
        accountErrorDto.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<>(accountErrorDto, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(InvalidAmountException.class)
    public ResponseEntity<AccountErrorDto> handleInvalidAmountException(InvalidAmountException e) {
        final AccountErrorDto accountErrorDto = new AccountErrorDto();
        accountErrorDto.setCode(HttpStatus.NOT_ACCEPTABLE.value());
        accountErrorDto.setMessage(e.getMessage());
        accountErrorDto.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<>(accountErrorDto, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(SuspendedAccountException.class)
    public ResponseEntity<AccountErrorDto> handleSuspendedAccountException(SuspendedAccountException e) {
        final AccountErrorDto accountErrorDto = new AccountErrorDto();
        accountErrorDto.setCode(HttpStatus.METHOD_NOT_ALLOWED.value());
        accountErrorDto.setMessage(e.getMessage());
        accountErrorDto.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<>(accountErrorDto, HttpStatus.METHOD_NOT_ALLOWED);
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
