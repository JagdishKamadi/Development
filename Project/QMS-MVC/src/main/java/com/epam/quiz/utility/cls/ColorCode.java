package com.epam.quiz.utility.cls;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ColorCode {

    public static final String RESET = "\033[0m";
    private static final Map<String, String> regularColorCodeMap;


    static {
        regularColorCodeMap = new HashMap<>();

        // add regular code
        regularColorCodeMap.put("GREEN", "\u001B[32m");
        regularColorCodeMap.put("RED", "\u001B[31m");
        regularColorCodeMap.put("BLUE", "\033[0;34m");
        regularColorCodeMap.put("CYAN", "\033[0;36m");
    }

    private ColorCode() {
        throw new IllegalStateException("");
    }

    public static Optional<String> getRegularColorCode(String colorName) {
        colorName = colorName.toUpperCase();
        return Optional.ofNullable(ColorCode.regularColorCodeMap.get(colorName));
    }

    public static String getResetColorCode() {
        return ColorCode.RESET;
    }
}
