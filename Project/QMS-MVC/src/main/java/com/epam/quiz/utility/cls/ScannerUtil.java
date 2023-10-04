package com.epam.quiz.utility.cls;
import java.util.Scanner;

public class ScannerUtil {
    static Scanner instance;

    private  ScannerUtil() {}

    public static  Scanner getConsoleScanner(){


            synchronized (ScannerUtil.class)
            {
                if(instance ==null)
                {
                    instance = new Scanner(System.in);
                }
            }

        return instance;
    }
}
