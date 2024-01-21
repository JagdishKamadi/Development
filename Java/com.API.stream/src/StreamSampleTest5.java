import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/*
    will see method reference
 */
public class StreamSampleTest5 {
    public static void main(String[] args) {

        List<Integer> lst = Arrays.asList(34, 56, 25, 75, 55, 32);

        // using method reference
        Optional<Integer> store = lst.stream()
                .filter(StreamSampleTest5::isDiv)
                .map(StreamSampleTest5::doubleIt)
                .findFirst();

        System.out.println(store);

    }


    public static boolean isDiv(Integer i)
    {
        System.out.println("Passing isDiv : "+i);
        return i%5==0;
    }
    public static int doubleIt(Integer i)
    {
        System.out.println("Passing DoubleIt : "+i);
        return i*i;
    }
}