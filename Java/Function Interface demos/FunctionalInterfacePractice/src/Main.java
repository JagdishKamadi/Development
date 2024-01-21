import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Creating an ArrayList object of integer type
        ArrayList<Integer> al = new ArrayList<Integer>();

        // Inserting elements to ArrayList class object
        // Custom input integer numbers
        al.add(2);
        al.add(6);
        al.add(9);
        al.add(4);
        al.add(20);
        Predicate<Integer> pred = (arg1)-> {
            return arg1%2==0;
        };


        List<Integer> lst = al.stream().filter(pred).collect(Collectors.toList());

        System.out.println(lst);
    }

    class MethodReferencing {
        public static void show(int i) {
            System.out.println("My name is khan");
        }
    }



}
