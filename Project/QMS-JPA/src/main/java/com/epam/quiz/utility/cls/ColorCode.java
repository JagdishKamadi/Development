package com.epam.quiz.utility.cls;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ColorCode {

    public static final String RESET = "\033[0m";
    final private static  Map<String,String> regularColorCodeMap ;
    final private static  Map<String,String> boldColorCodeMap ;


    static {
        regularColorCodeMap = new HashMap<>();
        boldColorCodeMap = new HashMap<>();

        // add regular code
        regularColorCodeMap.put("GREEN","\u001B[32m");
        regularColorCodeMap.put("RED","\u001B[31m");
        regularColorCodeMap.put("BLUE","\033[0;34m");
        regularColorCodeMap.put("CYAN","\033[0;36m");

        // add the bold code
        boldColorCodeMap.put("RED_BOLD","\033[1;31m");
        boldColorCodeMap.put("CYAN_BOLD","\033[1;36m");
        boldColorCodeMap.put("GREEN_BOLD","\033[1;32m");

    }

    public static String getRegularColorCode(String colorName)
    {
        colorName = colorName.toUpperCase();
        return ColorCode.regularColorCodeMap.get(colorName);
    }

    public static String getBoldColorCode(String colorName)
    {
        colorName = colorName.toUpperCase();
        return ColorCode.regularColorCodeMap.get(colorName);
    }

    public static String getResetColorCode()
    {
        return  ColorCode.RESET;
    }
}
