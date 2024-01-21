/*  Problem Statement
    Create a TreeSet that sorts the given set of numbers in reverse order
 */
import java.util.*;
import com.interf.fun.*;

public class TreeSetClass {
    public static void main(String[] args) {

        // lambda  expression to sort the treeset in reverse order
        ComparatorInterfacefForInteger test = (a,b)->
        {
            if(a>b)
                return -1;
            return 1;
        };

        // crete the tree set and initialize it
        // pass the second object of comparator
        TreeSet<Integer> treeSet = new TreeSet<>(   (a,b)->
                                                 {
                                                     if(a>b)
                                                         return -1;
                                                     return 1;
                                                 });
        treeSet.add(90);
        treeSet.add(40);
        treeSet.add(50);
        treeSet.add(10);
        treeSet.add(100);
        treeSet.add(20);
        treeSet.add(80);
        treeSet.add(60);
        treeSet.add(30);
        treeSet.add(70);

        // in descending order
        System.out.println(treeSet);
    }
}

