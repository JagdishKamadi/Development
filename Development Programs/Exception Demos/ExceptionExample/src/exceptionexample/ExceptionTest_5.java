/*
 * throw keyword
 * When you want to throw excplit exception that time we have to use the throw keyword
 */
package exceptionexample;
import java.util.*;

public class ExceptionTest_5 {
    public static void main(String args[])
    {
        
        try {
            Scanner sc = new Scanner(System.in);
            int x = sc.nextInt();

            if (x < 5) {
                throw new ArithmeticException("Enter number > 5");
            }

            System.out.println("Success");
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}
