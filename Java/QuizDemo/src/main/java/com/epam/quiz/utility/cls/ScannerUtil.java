package com.epam.quiz.utility.cls;
import java.util.Scanner;

public class ScannerUtil {
    static Scanner consoleInput;

    private  ScannerUtil() {}

    public static synchronized Scanner getConsoleScanner(){

        if(consoleInput == null)
        {
            consoleInput = new Scanner(System.in);
        }
        return consoleInput;
    }
}
