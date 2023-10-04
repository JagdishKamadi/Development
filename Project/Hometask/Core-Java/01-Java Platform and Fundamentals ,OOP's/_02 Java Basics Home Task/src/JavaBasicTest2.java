/*  Problem Statement
 Create "calculator" which takes two numbers and an operation from the
 command line and outputs the result of the operation to the console.
 Add addition, subtraction, multiplication and division.
 Extra task : provide option for reminder, calculate percentage

 */

import java.util.*;
public class JavaBasicTest2 {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            int num1 = sc.nextInt();  // to store value 1
            int num2 = sc.nextInt();  // to store value 2

            int add = num1+num2; // store Addition result
            int sub = num1-num2; // store Subtraction result
            int mul = num1*num2; // store Multiplication result
            int div = num1/num2; // store Division result

            System.out.println("Addition : "+add);    		// display Addition
            System.out.println("Subtraction : "+sub); 		// display Subtraction
            System.out.println("Multiplication : "+mul);	// display Multiplication
            System.out.println("Division : "+div);   		// display Division
        }

    }

}
