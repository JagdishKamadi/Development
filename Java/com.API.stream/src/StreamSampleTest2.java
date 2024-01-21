import java.util.Arrays;
import java.util.List;

public class StreamSampleTest2 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);

        // we want some of all element
        // 1) using traditional way
        int sum=0;

        for(int i:list)
            sum+=i;

        System.out.println(sum);

        // 1) using stream API
        // it's a very simple
        int sum1 = list.stream().map(i->i).reduce(0,(start,inc)->start+inc);
        System.out.println(sum1);

        // how to double  each element
        /*  How it works
            list.stream() = convert into the stream
         */
        int sum2 = list.stream().map(i->i*2).reduce(0,(start,inc)->start+inc);
        System.out.println("Double sum : "+sum2);

        List<Integer> list2 = Arrays.asList(1,2,3,4,5);

        Integer store = list2.stream().map(i->i*2).reduce(0,(start,inc)->start+inc);
        System.out.println(store);
    }
}
