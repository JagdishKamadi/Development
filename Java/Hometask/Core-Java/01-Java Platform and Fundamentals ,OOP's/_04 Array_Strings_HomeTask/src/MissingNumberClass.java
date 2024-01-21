/*  Problem Statement
Write a program to find the missing number in integer array of 1 to 100 -
 */

import java.util.*;
public class MissingNumberClass {
    public static void main(String args[])
    {
        try (Scanner sc = new Scanner(System.in)) {

            int size = sc.nextInt();	// for array size
            int arr[] = new int[size];

            for(int i=0;i<size;i++)		// taking input in array
                arr[i] = sc.nextInt();

            missingNumberFromArray(arr);   // showing missing number in array
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

    public static void missingNumberFromArray(int arr[])
    {
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> tempList = new ArrayList<Integer>();

        // adding array element to list
        for(int i:arr)
            tempList.add(i);


        // to store the value from 1 to 100 in list
        for(int i=1;i<=100;i++)
            list.add(i);

        // remove all element present in templist
        list.removeAll(tempList);

        // display remaining element
        for(int i:list)
            System.out.print(i+" ");

    }
}

