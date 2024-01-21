/*
 * We are difining our exception here
 */
package exceptionexample;
import java.util.*;

public class ExceptionTest_6 {
    public static void main(String args[])
    {
        try {
            Scanner sc = new Scanner(System.in);
            int x = sc.nextInt();

            if (x < 5) {
                throw new MyException("Enter number > 5");
            }
            
            System.out.println("Success");
        } catch (MyException e) {
            System.out.print(e);
        }
    }
}

class MyException extends Exception
{
    public MyException(String msg)
    {
        super(msg);  // we need to call Exception class constructor
    }
}
