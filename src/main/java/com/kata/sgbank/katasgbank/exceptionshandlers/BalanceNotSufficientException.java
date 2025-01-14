package com.kata.sgbank.katasgbank.exceptionshandlers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BalanceNotSufficientException extends RuntimeException {
    private String message;

}
