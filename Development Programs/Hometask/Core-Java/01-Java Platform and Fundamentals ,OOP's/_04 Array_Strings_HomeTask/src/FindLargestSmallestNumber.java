/*  Problem Statement
  Write a program to find biggest and smallest number in a array.
 */

import java.util.*;
public class FindLargestSmallestNumber {
    public static void main(String args[])
    {
        try (Scanner sc = new Scanner(System.in)) {

            int size = sc.nextInt();	// for array size
            int arr[] = new int[size];

            for(int i=0;i<size;i++)		// taking input in array
                arr[i] = sc.nextInt();

            // calling method from myclass which is printing min and max number
            getMaxMinNumber(arr);

        }

        catch(ArrayIndexOutOfBoundsException e)  // if cross limit, catch exception
        {
            System.out.print(e.getMessage());
        }
        catch(Exception e)                       // unknown exception will catch
        {
            System.out.print("Unknown Exception: "+e.getMessage());
        }

    }


    public static void getMaxMinNumber(int arr[])
    {
        int min = arr[0];	// initialize min with arr[0] value
        int max = arr[0];	// initialize max with arr[0] value

        for(int i:arr)
        {
            if(i<min)		// if small then assign to min
                min = i;

            if(i>max)		// if big then assign to max
                max=i;
        }

        System.out.println("Max : "+max);	// display max value
        System.out.println("Min : "+min);	// display min value

    }
}


