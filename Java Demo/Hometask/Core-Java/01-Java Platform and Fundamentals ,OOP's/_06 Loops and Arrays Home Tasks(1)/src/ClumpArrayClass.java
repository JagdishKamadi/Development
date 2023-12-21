/*  Problem Statement
    Say that a "clump" in an array is a series of 2 or more adjacent elements of the same value.
    Return the number of clumps in the given array.
 */

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class ClumpArrayClass {
    // driver code
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            // take the input as size of array
            int size = scanner.nextInt();
            int nums[] = new int[size];

            // to receive the different int input in array
            for (int i = 0; i < size; i++)
                nums[i] = scanner.nextInt();

            // to store the count
            int count = countClumps(nums);
            // to display the result
            System.out.println(count);
        }
        }
    public static  int countClumps(int[] arr) {
        int l = arr.length;
        // Initialise count of clumps as 0
        int clumps = 0;

        // Traverse the arr[]
        for (int i = 0; i < l - 1; i++) {
            int flag = 0;
            // Whenever a sequence of same
            // value is encountered
            while (i < l - 1  && arr[i] == arr[i + 1]) {
                flag = 1;
                i++;
            }

            if (flag == 1)
                clumps++;
        }

        // Return the count of clumps
        return clumps;
    }

}
