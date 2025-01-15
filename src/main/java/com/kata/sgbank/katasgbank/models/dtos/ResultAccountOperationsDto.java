package com.kata.sgbank.katasgbank.models.dtos;

import com.kata.sgbank.katasgbank.models.enums.AccountStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultAccountOperationsDto {

    private Long accountId;
    private double balance;
    private AccountStatus status;
    private List<AccountOperationDto> accountOperations;

}
