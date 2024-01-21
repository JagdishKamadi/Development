/*   Problem Statement
    Given 2 non-negative ints, a and b, return their sum, so long as the sum has the same number of digits as a.
    If the sum has more digits than a, just return a without b. (Note: one way to compute the number of digits of
    a non-negative int n is to convert it to a string with String.valueOf(n) and then check the length of the string.)
 */

import java.util.Scanner;

public class SumLimitClass {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            // receiving input
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();

            // storing the result
            int result = sumLimit(num1,num2);
            // display the result
            System.out.println(result);
        }
    }

    public static int sumLimit(int a, int b) {
        // doing sum and then convert into the string so that we can find length
        String sum = String.valueOf(a+b);
        String aLen = String.valueOf(a);

        return (sum.length() == aLen.length()) ? (a+b):a;
    }

}
