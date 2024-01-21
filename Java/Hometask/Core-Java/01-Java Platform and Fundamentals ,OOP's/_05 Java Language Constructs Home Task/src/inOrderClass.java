/*  Problem Statement
Given three ints, a b c, return true if b is greater than a, and c is greater than b. However,
with the exception that if "bOk" is true, b does not need to be greater than a
 */

import java.util.Scanner;

public class inOrderClass {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in))
        {
            // receive input
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            boolean bOk = sc.nextBoolean();

            // store the result
            boolean result = inOrder(a,b,c,bOk);
            // display the result
            System.out.println(result);
        }
    }

    public static boolean inOrder(int a, int b, int c, boolean bOk) {

        // if bOk is false
        if(!bOk)
        {
            // then have to check two condition
            if((b>a && c>b) )
                return true;
            else
                return false;
        }

        // if bOk is true then check only one condition
        if(c>b)
            return true;
        else
            return false;
    }

}
