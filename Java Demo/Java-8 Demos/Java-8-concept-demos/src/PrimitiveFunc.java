import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.stream.IntStream;

public class PrimitiveFunc {

    public static void main(String[] args) {
        int[] arr = IntStream.range(1, 500000).toArray();
        BinaryOperator<Integer> f1 = (i, j) -> i + j;
        IntBinaryOperator f2 = (i, j) -> i + j;

        // RunningTime is an utility class to calculate execution time
        LocalTime localTime1 = LocalTime.now();
        reduceWrapper(arr, f1);
        LocalTime localTime2 = LocalTime.now();
        System.out.println(localTime1.until(localTime2, ChronoUnit.MICROS));
        reducePrimitive(arr, f2);
        localTime1 = LocalTime.now();
        System.out.println(localTime2.until(localTime1, ChronoUnit.MICROS));
    }

    static int reduceWrapper(int[] arr, BinaryOperator<Integer> operator) {
        int result = arr[0];

        for (int i = 0; i < arr.length; i++) {
//            System.out.println("Calling");
            result = operator.apply(result, arr[i]);  // Boxing and Unboxing here
        }
        return result;
    }

    static int reducePrimitive(int[] arr, IntBinaryOperator operator) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = operator.applyAsInt(result, arr[i]);
        }
        return result;
    }
}