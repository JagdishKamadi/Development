import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

public class StreamSampleTest3 {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(12,20,34,45,50,56,85);


        // sum of all value which is divisible by 5
        // using stream we can do it

        System.out.println(list.stream()
                               .filter(i->(i%5==0)) // takes Predicate interface Object
                               .reduce(0,(c,e)->c+e)); // takes BinaryOperator object

        // another way of doing
        // filter method takes predicate interface object
        // makes the predicate interface object first

        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer%5==0;
            }
        };



        // makes the BinaryOperator object
        BinaryOperator<Integer> binaryOperator = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer+integer2;
            }
        };



        // now store the result
        int store = list.stream()
                        .filter(predicate)
                        .reduce(0,binaryOperator);

        System.out.println("Using anonymous class : "+store);

        // using lambda expression
        Predicate<Integer> predicate1 = (i)->
        {
            return i%5==0;
        };
        BinaryOperator<Integer> binaryOperator1 = (c,e)->
        {
            return c+e;
        };

        Optional<Integer> store1 = list.stream()
                    .filter(predicate1)
                    .reduce(binaryOperator1);

        System.out.println("Using Lambda expression : "+store1);

    }
}
