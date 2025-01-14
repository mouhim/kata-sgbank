package com.kata.sgbank.katasgbank.models.dtos;

import com.kata.sgbank.katasgbank.models.enums.AccountStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankAccountDto {

    private Long id;
    private double balance;
    private Date createdAt;
    private AccountStatus status;
    private List<AccountOperationDto> accountOperations;
}
