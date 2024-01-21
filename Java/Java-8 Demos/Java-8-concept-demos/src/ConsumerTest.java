import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ConsumerTest {
    public static void main(String[] args) {

        List<Integer> storeInTheList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            storeInTheList.add(i);
        }
        Consumer<Integer> printOnConsole = (arg -> System.out.printf("%d ", arg));
        Consumer<Integer> oddNumber = arg -> {
            if (arg % 2 != 0) {
                System.out.println(arg + " ");
            }
        };
        System.out.println("Before " + storeInTheList);
        showData(storeInTheList, printOnConsole);
        System.out.println();
        showData(storeInTheList, printOnConsole.andThen(oddNumber));
    }

    public static void showData(List<Integer> data, Consumer<Integer> consumer) {
        data.stream().forEach(args -> consumer.accept(args));
    }
}
