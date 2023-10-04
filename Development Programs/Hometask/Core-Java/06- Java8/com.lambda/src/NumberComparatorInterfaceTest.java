/*  Problem Statement
     Use Comparator interface to sort given list of numbers in reverse order
 */

import java.util.*;
import com.interf.fun.*;
public class NumberComparatorInterfaceTest {
    // drive code
    public static void main(String[] args) {

        // List of Int element
        List<Integer> list = new ArrayList<>(Arrays.asList(10,9,45,1,2,-1,78,0));

        // simple lambda expression to sort the value
        ComparatorInterfacefForInteger comparatorInterfacefForInteger = (a, b)->
        {
            // if first greater than second return false;
            if(a>b)
                return -1;
            else
                return 1;
        };

        // pass the second argument of comparator interface
        Collections.sort(list, comparatorInterfacefForInteger);
        System.out.println(list);

    }
}



