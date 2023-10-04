/*  Problem Statement
    Generate Pyramid For a Given Number Example
    --> Generate the Pyramid with while loop -- 5 Marks
    --> Generate the Pyramid with do.. while loop -- 5 Marks
    --> Generate the Pyramid with for loop -- 5 Marks
    --> marks for clean code - 5
 */
import java.util.Scanner;

public class Main {

    // Driver code
    public static void main(String args[])
    {

        try (Scanner sc = new Scanner(System.in)) {
            // for external layer value
            System.out.print("Enter Number: ");
            int number = sc.nextInt();
            // to increment layer by x
            System.out.print("Enter X: ");
            int x = sc.nextInt();

            // printing pattern using while loop
            PatternClass.usingWhileLoop(number, x);
            PatternClass.space(number);

            // printing pattern using for loop
            PatternClass.usingForLoop(number,x);
            PatternClass.space(number);

            // printing pattern using do while loop
            PatternClass.usingDoWhileLoop(number, x);
            PatternClass.space(number);
        }
    }
}
