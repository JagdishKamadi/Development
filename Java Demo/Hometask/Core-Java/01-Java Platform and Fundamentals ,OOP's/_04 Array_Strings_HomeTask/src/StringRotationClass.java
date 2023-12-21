/* Problem Statement
 write a program to check if two strings are rotations of each other
 */

import java.util.*;

public class StringRotationClass {

    /* Function checks if passed strings (str1 and str2)
    are rotations of each other */
    public static  boolean isRotationoofEachOther(String str1, String str2)
    {
        // There lengths must be same and str2 must be
        // a substring of str1 concatenated with str1.
        return (str1.length() == str2.length()) &&
                ((str1 + str1).indexOf(str2) != -1);
    }


    // Driver method
    public static void main(String []args)
    {
        try (Scanner sc = new Scanner(System.in)) {
            String str1 = sc.next();
            String str2 = sc.next();

            // if true then print rotation of each other
            if (isRotationoofEachOther(str1, str2))
                System.out.println("Strings are rotations of each other");
            else
                System.out.printf("Strings are not rotations of each other");
        }
    }

}

