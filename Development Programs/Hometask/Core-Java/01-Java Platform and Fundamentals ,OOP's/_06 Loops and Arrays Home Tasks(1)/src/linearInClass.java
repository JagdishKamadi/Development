/*  Problem Statement
    Given two arrays of ints sorted in increasing order, outer and inner, return true if all of
    the numbers in inner appear in outer. The best solution makes only a single "linear" pass of
    both arrays, taking advantage of the fact that both arrays are already in sorted order.
 */
import java.util.*;
public class linearInClass {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {

            // take the input as size of outer array
            int sizeofOuter = scanner.nextInt();
            int outer[] = new int[sizeofOuter];

            // to receive the multiple input in array
            for (int i = 0; i < sizeofOuter; i++)
                outer[i] = scanner.nextInt();

            // take the input as size of inner array
            int sizeofInner = scanner.nextInt();
            int inner[] = new int[sizeofInner];

            // to receive the multiple input in array
            for (int i = 0; i < sizeofInner; i++)
                inner[i] = scanner.nextInt();

            // to store the count
            boolean result = linearIn(outer,inner);
            // to display the result
            System.out.println(result);
        }
    }
    
    public static boolean linearIn(int[] outer, int[] inner) {
        // store unique element from outer
        Set<Integer> set = new HashSet<>();

        // add value into set from outer array
        for(int i:outer)
            set.add(i);

        // traverse the inner array
        for(int i:inner)
        {
            // if inner element not present in outer
            // return false
            if(!set.contains(i))
                return false;
        }

        // contains all element
        return true;
    }
}
