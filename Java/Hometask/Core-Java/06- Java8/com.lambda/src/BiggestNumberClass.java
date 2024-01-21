/*  Problem Statement
    Find the 2nd biggest number in the given list of numbers
 */

import  com.interf.fun.*;
import java.util.*;
public class BiggestNumberClass {
    public static void main(String[] args) {

        // create the list
        // also adding value
        List<Integer> list = new ArrayList<>(Arrays.asList(45,3,67,90,-3,2,47,89));

        // sort the number first
        // using lambda expression
        ComparatorInterfacefForInteger comp = (a,b)->
        {
            // if first is greater than second then return true else false
            if(a>b)
                return 1;
            return -1;
        };

        Comparator<Integer> com = new Comparator<Integer>() {
          public int compare(Integer o1,Integer o2)
          {
              if (o1>o2)
                  return 1;

              return -1;
          }
        };


        // sort the list
        Collections.sort(list,(a,b)->
        {
            // if first is greater than second then return true else false
            if(a>b)
                return 1;
            return -1;
        });
        // get the second last element
        int res = list.get(list.size()-2);
        // display the result
        System.out.println(res);
    }
}
