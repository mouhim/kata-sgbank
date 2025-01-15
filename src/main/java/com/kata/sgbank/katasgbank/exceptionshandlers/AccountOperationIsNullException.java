package com.kata.sgbank.katasgbank.exceptionshandlers;

public class AccountOperationIsNullException extends RuntimeException {
    private String message;

    public AccountOperationIsNullException(String message) {
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
