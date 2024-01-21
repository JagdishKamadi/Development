/*   Problem Statement
 Given two ints, each in the range 10..99, return true if there is a digit that appears in both numbers,
 such as the 2 in 12 and 23. (Note: division, e.g. n/10,
 gives the left digit while the % "mod" n%10 gives the right digit.)
 */

import java.util.Scanner;

public class ShareDigitClass {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            // receiving input
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();

            // storing the result
            boolean result = shareDigit(num1,num2);
            // display the result
            System.out.println(result);
        }

    }

    public static boolean shareDigit(int num1,int num2)
    {
        // compare all possible combination
        boolean res1 = (num1%10) == (num2%10);
        boolean res2 = (num1%10) == (num2/10);
        boolean res3 = (num1/10) == (num2%10);
        boolean res4 = (num1/10) == (num2/10);

        // even if one case passed then return true else false
        return (res1 || res2 || res3 || res4);
    }
}


