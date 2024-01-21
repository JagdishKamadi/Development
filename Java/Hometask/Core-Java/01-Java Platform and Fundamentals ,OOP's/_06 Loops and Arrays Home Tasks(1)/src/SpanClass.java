/*  Problem Statement
    Consider the leftmost and righmost appearances of some value in an array.
    We'll say that the "span" is the number of elements between the two inclusive. A single value has a span of 1.
    Returns the largest span found in the given array. (Efficiency is not a priority.)
 */
import java.util.*;

public class SpanClass {
    // driver code
    public static void main(String[] args) {
       try( Scanner sc = new Scanner(System.in))
       {
           // take the input as size of array
           int size = sc.nextInt();
           int nums[] = new int[size];

           // to receive the different int input in array
           for (int i = 0; i < size; i++)
               nums[i] = sc.nextInt();

           // storing the result
           int diff = maxSpan(nums);
           // display the result
           System.out.println(diff);

       }
    }

    public static int maxSpan(int[] nums) {

        // check initial condition
        // if length is one then return 1
        if(nums.length==0)
            return 0;
        else if(nums.length==1 || (nums.length==2 && nums[0]!=nums[1]))
            return 1;
        // if length is and match both element then return 2
        else if(nums.length==2 && nums[0]==nums[1])
            return 2;

        // to store the first occurrence  of element
        Map<Integer,Integer> firstOccurence = new HashMap<>();
        // to store the last occurrence  of element
        Map<Integer,Integer> lastOccurence = new HashMap<>();

        // store the first occurrence with index value
        for(int i=0;i<nums.length;i++)
        {
            if(!firstOccurence.containsKey(nums[i]))
                firstOccurence.put(nums[i],i);
        }

        // store the last occurrence with index value
        for(int i=nums.length-1;i>=0;i--)
        {
            if(!lastOccurence.containsKey(nums[i]))
                lastOccurence.put(nums[i],i);
        }

        // allow only unique element
        Set<Integer> set = new HashSet<>();

        for(int i:nums)
            set.add(i);

        // to store the maximum span
        int max=0;
        // traverse each element
        for(int i:set)
        {
            // check the first and last index  exit or not
            if((firstOccurence.containsKey(i) && lastOccurence.containsKey(i))
                    &&(firstOccurence.get(i)!=lastOccurence.get(i)))
            {
                // if exist then find the difference
                int diff = Math.abs(firstOccurence.get(i)-lastOccurence.get(i));

                // if current difference is max than max then update max
                if(diff>max)
                    max=diff;
            }
        }

        // return final max difference
        return max+1;
    }

}

