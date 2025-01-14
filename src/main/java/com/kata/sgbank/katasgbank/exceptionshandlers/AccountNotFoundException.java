package com.kata.sgbank.katasgbank.exceptionshandlers;


public class AccountNotFoundException extends RuntimeException {
    private String message;

    public AccountNotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
