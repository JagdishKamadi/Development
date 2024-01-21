/*   Problem Statement
You have a blue lottery ticket, with ints a, b, and c on it.
This makes three pairs, which we'll call ab, bc, and ac.
Consider the sum of the numbers in each pair.
If any pair sums to exactly 10, the result is 10.
Otherwise if the ab sum is exactly 10 more than either bc or ac sums,
 the result is 5. Otherwise the result is 0.
 */
import java.util.Scanner;

public class LotteryClass {
    public static void main(String[] args) {

        try(Scanner sc = new Scanner(System.in)) {
            // receive the value of a,b,c
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            // to store the result
            int result = blueTicket(a,b,c);
            // to print the output
            System.out.println(result);

        }
    }

    // this method give the result based on pair
    public static int blueTicket(int a, int b, int c) {
        int ab = a + b;
        int bc = b + c;
        int ac = a + c;

        // if one of value is 10
        if (ab == 10 || bc == 10 || ac == 10)
            return 10;
        // if ab is equal to 10 more
        else if( (ab == bc+10) || (ab == ac+10))
            return 5;
        else
            return 0;
    }

}


