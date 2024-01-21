package com.epam.utility.cls;


public class MethodUtility {


    public static String acceptOption()
    {
        System.out.println("Enter the option ");
        String option = ScannerUtil.getConsoleScanner().next();
        return option;
    }
}
