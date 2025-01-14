package com.kata.sgbank.katasgbank.utils;

import com.google.gson.Gson;
import com.kata.sgbank.katasgbank.models.dtos.AccountDto;
import com.kata.sgbank.katasgbank.models.dtos.DepositDto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonsUtils {

    public JsonsUtils() {
    }

    public static String loadJsonFile(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    public static DepositDto strJsonToDepositDto(String strJson) throws IOException {
        final Gson gson = new Gson();
        return gson.fromJson(strJson, DepositDto.class);
    }

    public static AccountDto strJsonToAccountDto(String strJson) throws IOException {
        final Gson gson = new Gson();
        return gson.fromJson(strJson, AccountDto.class);
    }


}
