/*  Problem Statement
    Given two strings, base and remove, return a version of the base string
    where all instances of the remove string have
    been removed (not case sensitive). You may assume that the remove string is length 1 or more.
    Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x"
 */
import java.util.*;
public class WithoutStringClass {
    public static void main(String[] args) {

        try(Scanner scanner = new Scanner((System.in)))
        {
            // receive base
            String base = scanner.nextLine();
            // receive remove string
            String remove = scanner.nextLine();

            // store the final string
            String finalString = withoutString(base,remove);
            // display the result
            System.out.println(finalString);
        }
    }

    // Method to remove the string from base
    public static  String withoutString(String base, String remove) {
        // first remove all upper Case string
        base=base.replace(remove.toUpperCase(),"");
        // second remove all lower Case string
        base=base.replace(remove.toLowerCase(),"");

        // finally remove the string as it is
        return base.replace(remove,"");
    }
}
