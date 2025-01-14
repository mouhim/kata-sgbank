package com.kata.sgbank.katasgbank.models.entities;

import com.kata.sgbank.katasgbank.models.dtos.BankAccountDto;
import com.kata.sgbank.katasgbank.models.enums.OperationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountOperationEntity {

    private Long id;
    private Date operationDate;
    private double amount;
    private OperationType type;
    private BankAccountDto bankAccount;
    private String description;
}
