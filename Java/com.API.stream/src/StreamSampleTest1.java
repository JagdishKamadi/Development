import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Stream;

public class StreamSampleTest1 {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,2,3,4,5);

        // now we are applying individually stream object now
        // following are the step we have to follow for stream

        // 1) convert into the stream first
        Stream<Integer> s = list.stream();

        // 2) now takes Function interface input
        // using Function Interface you can perform some operation
        Function<Integer,Integer> function = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer*2;
            }
        };
        // so now
        Stream<Integer> s1 = s.map(function);
        // check by printing value
        list.stream().forEach(i-> System.out.println(i));

        // 3) if you want to apply the reduce function
        // see the parameter for reduce function
        // we have to create the object of BinaryOperator

        BinaryOperator<Integer> binaryOperator = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer+integer2;
            }
        };

        // we have doubled the value and store it
        Integer store = s1.reduce(0,binaryOperator);

        // successful operation
        System.out.println(store);

        // in the next video we will see the shortcut of stream
    }
}
