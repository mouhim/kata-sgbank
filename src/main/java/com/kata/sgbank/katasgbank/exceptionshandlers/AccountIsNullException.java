package com.kata.sgbank.katasgbank.exceptionshandlers;

public class AccountIsNullException extends RuntimeException {
    private String message;

    public AccountIsNullException(String message) {
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
