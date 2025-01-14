package com.kata.sgbank.katasgbank.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankAccountErrorDto {

    private int code;
    private String message;
    private LocalDateTime timestamp;
}
