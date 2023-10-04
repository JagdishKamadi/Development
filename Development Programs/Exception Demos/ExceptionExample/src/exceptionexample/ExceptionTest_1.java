/*
 Example of UnChecked Exception
*/
package exceptionexample;
import java.util.*;
import java.io.*;

public class ExceptionTest_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int res = x / y;
            System.out.println("Result : " + res);
        } catch (ArithmeticException e) {
            System.out.println("Can't divide by zero " + e.getMessage());
        } catch (Exception e) // generilized exception
        {
            System.out.println("Other Exception " + e.getMessage());
        } finally {
            System.out.println("Exit program");
            sc.close();
        }

    }

}
