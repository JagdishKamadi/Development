/*  Problem Statement
    Given a string, return the sum of the numbers appearing in the string,
    ignoring all other characters. A number is a series of 1 or more digit chars in a row.
    (Note: Character.isDigit(char) tests if a char is one of the chars '0', '1', .. '9'.
    Integer.parseInt(string) converts a string to an int.)
 */

import java.util.Scanner;

public class SumNumberClass {
    // driver code
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in))
        {
            // receive input
            String str = sc.nextLine();

            // store the result
            int sum = sumNumbers(str);
            // display the result
            System.out.println(sum);
        }
    }

    // sumNumbers method calculate the sum of integer in string
    public static int sumNumbers(String str) {
        // for pointing current integer
        String currentString="";
        // to store final sum
        int sum=0;
        // append the '-' character at last, to avoid exception
        str+="-";

        // apply fon loop till (length-1)
        for(int i=0;i<str.length()-1;i++)
        {
            char ch1 = str.charAt(i);       // pointing current character
            char ch2 = str.charAt(i+1);     // pointing next character
            if(Character.isDigit(ch1))      // check weather digit or not
            {
                if(Character.isDigit(ch2))  // to check next digit
                {
                    currentString +=ch1;    // if yes then update currentString value
                }
                else {
                    currentString +=ch1;    // if no then update currentString value
                    sum =sum+Integer.parseInt(currentString);   // convert into the integer and store it
                    currentString="";       // make currentString blank
                }
            }
        }
        return sum;         // return total sum
    }

}
