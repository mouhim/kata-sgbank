package com.kata.sgbank.katasgbank.exceptionshandlers;

import com.kata.sgbank.katasgbank.models.dtos.BankAccountErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(BankAccountNotFoundException.class)
    public ResponseEntity<BankAccountErrorDto> handleAccountNotFoundException(BankAccountNotFoundException e) {
        final BankAccountErrorDto bankAccountErrorDto = new BankAccountErrorDto();
        bankAccountErrorDto.setCode(HttpStatus.NOT_FOUND.value());
        bankAccountErrorDto.setMessage(e.getMessage());
        bankAccountErrorDto.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<>(bankAccountErrorDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BalanceNotSufficientException.class)
    public ResponseEntity<BankAccountErrorDto> handleBalanceNotSufficientException(BalanceNotSufficientException e) {
        final BankAccountErrorDto bankAccountErrorDto = new BankAccountErrorDto();
        bankAccountErrorDto.setCode(HttpStatus.NOT_ACCEPTABLE.value());
        bankAccountErrorDto.setMessage(e.getMessage());
        bankAccountErrorDto.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<>(bankAccountErrorDto, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BankAccountErrorDto> handleProjectWebException(Exception e) {
        final BankAccountErrorDto bankAccountErrorDto = new BankAccountErrorDto();
        bankAccountErrorDto.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        bankAccountErrorDto.setMessage(e.getMessage());
        bankAccountErrorDto.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<>(bankAccountErrorDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
