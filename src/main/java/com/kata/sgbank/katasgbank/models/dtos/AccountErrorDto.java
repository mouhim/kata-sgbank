package com.kata.sgbank.katasgbank.models.dtos;

import java.time.LocalDateTime;

public class AccountErrorDto {

    private int code;
    private String message;
    private LocalDateTime timestamp;

    public AccountErrorDto() {
    }

    public AccountErrorDto(int code, String message, LocalDateTime timestamp) {
        this.code = code;
        this.message = message;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BankAccountErrorDto{");
        sb.append("code=").append(code);
        sb.append(", message='").append(message).append('\'');
        sb.append(", timestamp=").append(timestamp);
        sb.append('}');
        return sb.toString();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
