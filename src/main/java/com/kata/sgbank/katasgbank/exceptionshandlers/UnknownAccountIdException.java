package com.kata.sgbank.katasgbank.exceptionshandlers;

public class UnknownAccountIdException extends RuntimeException {
    private String message;

    public UnknownAccountIdException(String message) {
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
