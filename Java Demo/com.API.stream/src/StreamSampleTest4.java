import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/*
    In this code we will see the method
    1) findFirst
    2) orElse
 */
public class StreamSampleTest4 {
    public static void main(String[] args) {

        List<Integer> lst = Arrays.asList(34,56,25,75,55,32);

        // use findFirst
        Optional<Integer> store1 = lst.stream()
                                      .filter(i->i%5==0)
                                      .findFirst();

        System.out.println(store1);

        // second
        List<Integer> lst2 = Arrays.asList(1,2,3,6,7,8);
        Optional<Integer> store2 = lst2.stream()
                                       .filter(i->i%5==0)
                                       .findFirst();

        // it should print empty
        System.out.println(store2);

        Optional<Integer> store3 = lst2.stream()
                                        .map(i->(i*3))      // triple the value first
                                        .filter(i->i%5==0)  // now apply filter
                                        .findFirst();       // if present then return

        System.out.println(store3);

        // you can vice versa filter and map
        Optional<Integer> store4 = lst2.stream()
                                        .filter(i->i%3==0)  // now apply filter
                                        .map(i->(i*2))      // triple the value first
                                        .findFirst();       // if present then return
        System.out.println(store4);

        // now we see the result of orElse
        Optional<Integer> store5 = Optional.of(lst2.stream()
                .filter(i -> i % 5 == 0)  // now apply filter
                .map(i -> (i * 2))      // triple the value first
                .findFirst()       // if present then return
                .orElse(0));

    }
}
