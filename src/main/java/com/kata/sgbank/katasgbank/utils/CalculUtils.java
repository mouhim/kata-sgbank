package com.kata.sgbank.katasgbank.utils;

public class CalculUtils {

    public CalculUtils() {
    }

    public static Long generateIdRandom() {
        // Generate random integers in range 0 to 999
        double randomId = Math.random() * 1000;

        return (long) randomId;
    }

}
