/*  Problem Statement
    Given a non-empty array, return true if there is a place to split the array so that the
    sum of the numbers on one side is equal to the sum of the numbers on the other side.
 */

import org.jetbrains.annotations.Contract;

import java.util.*;
public class BalanceClass {
    // driver code
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in))
        {
            // take the input as size of array
            int size = scanner.nextInt();
            int nums[] = new int[size];

            // to receive the different int input in array
            for(int i=0;i<size;i++)
                nums[i] = scanner.nextInt();

            // to store the result
            boolean result = canBalance(nums);
            // to display the result
            System.out.println(result);

        }

    }


    public static boolean canBalance(int[] nums) {
        // traverse array element and compute sum of whole array
        int sum=0;
        for(int i:nums)
            sum+=i;

        // again traverse array and compute leftSum
        // sum and also check leftSum equal to
        // sum  or not
        int leftSum=0;
        for(int i=0;i<nums.length;i++)
        {
            // add current element to left sum
            leftSum+=nums[i];
            // exclude current element to the sum
            sum-=nums[i];

            // it split then return true
            if(leftSum==sum)
                return true;
        }
        // if it is not possible to split array
        // into two parts.
        return false;
    }
}
