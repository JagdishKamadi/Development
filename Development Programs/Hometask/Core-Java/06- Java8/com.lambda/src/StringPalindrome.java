/*  Problem Statement
    1. Check if a given string is a palindrome
 */

import java.util.Scanner;

public class StringPalindrome {
    // Driver code
    public static void main(String[] args) {

        // try with resource
        try(Scanner sc = new Scanner(System.in))
        {
            // receive the input
            String string = sc.nextLine();

            // lambda function for palindrome check
            StringPalindromeInterface stringPalindromeIn = (str)->
                    {
                        // maintain original string
                        String orgStr = str;

                        // for performing reverse operation
                        StringBuilder sb = new StringBuilder(str);
                        // reverse the string
                        sb.reverse();

                        // if same return true or return false
                        return str.equals(sb.toString());
                    };

            // if true print Palindrome
            if(stringPalindromeIn.isPal(string))
                System.out.println("Palindrome");
            else
                System.out.println("Not-Palindrome");
        }
    }
}

// this is functional interface
@FunctionalInterface
interface StringPalindromeInterface
{
    // method for checking Palindrome or not
    boolean isPal(String str);
}

