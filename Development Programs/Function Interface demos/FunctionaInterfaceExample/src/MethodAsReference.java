import java.util.*;
public class MethodAsReference {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);

        // see the feature of java 8
        // this is called method reference
        // :: called scope resolution
        list.forEach(System.out::println);
        list.forEach(System.out::print);
    }
}
