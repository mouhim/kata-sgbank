package com.kata.sgbank.katasgbank.exceptionshandlers;


public class InvalidAmountException extends RuntimeException {
    private String message;

    public InvalidAmountException(String message) {
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
