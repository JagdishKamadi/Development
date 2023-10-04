/*   Problem Statement
The number 6 is a truly great number. Given two int values, a and b,
return true if either one is 6. Or if their sum or difference is  6.
Note: the function Math.abs(num) computes the absolute value of a number.
 */

import java.util.*;

public class GreatNumberClass {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();

            // to store the result
            boolean result = isGreatNumber(num1,num2);
            // display result
            System.out.println(result);
        }
    }

    // give the boolean value weather number is great or not
    public static boolean isGreatNumber(int num1,int num2)
    {
        // verifying all condition, if one of matched then return true
        if((num1==6 || num2==6) || (Math.abs(num1-num2)==6) || (num1+num2)==6)
            return true;
        else
            return false;
    }

}

