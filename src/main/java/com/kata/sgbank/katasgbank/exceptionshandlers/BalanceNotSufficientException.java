package com.kata.sgbank.katasgbank.exceptionshandlers;


public class BalanceNotSufficientException extends RuntimeException {
    private String message;

    public BalanceNotSufficientException(String message) {
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
