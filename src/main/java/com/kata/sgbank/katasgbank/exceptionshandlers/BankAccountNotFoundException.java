package com.kata.sgbank.katasgbank.exceptionshandlers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BankAccountNotFoundException extends RuntimeException {
    private String message;

}
