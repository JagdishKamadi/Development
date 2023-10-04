package com.epam.utility;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        String colorName="";


       while(!flag){
           System.out.println("Enter color name : ");
           colorName = sc.next();
           flag = isColorPresent(colorName);
       }
        System.out.println(colorName);
    }

    public static boolean isColorPresent(String colorName)
    {

        for(Color color : Color.values())
        {
            if(color.name().equalsIgnoreCase(colorName))
            {
                return true;
            }
        }
        return false;
    }
}

enum Color{
    RED,
    BLACK,
    GREEN
}
