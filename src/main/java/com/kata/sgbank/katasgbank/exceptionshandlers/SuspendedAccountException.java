package com.kata.sgbank.katasgbank.exceptionshandlers;

public class SuspendedAccountException extends RuntimeException {
    private String message;

    public SuspendedAccountException(String message) {
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
