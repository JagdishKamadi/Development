package stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        List<Employee> listOfEmployees = getEmployees();
        Comparator<Employee> comp = Comparator.comparing(Employee::getName);

        List<Employee> sortedEmployee = listOfEmployees.stream().filter(e -> e.getName().startsWith("J")).sorted(comp).collect(Collectors.toList());

        sortedEmployee.forEach(e -> System.out.println(e.getName()));

        List<Employee> employeeList = listOfEmployees.stream().filter(e -> e.getName().startsWith("J")).limit(2).collect(Collectors.toList());

        System.out.println(employeeList);

        // generate the stream from the array
        int arr[] = {1, 2, 3, 4, 5};

        long evenCount = Arrays.stream(arr)
                .filter(i -> i % 2 == 0)
                .count();

        System.out.println("Even count number " + evenCount);

        OptionalInt opt = new Random().ints().filter(no -> no % 10 == 0).findAny();
        System.out.println(opt.getAsInt());

        // peak vs forEach
        Stream<Integer> stream = Stream.of(1, 2, -3, 4, 5);
        List<Integer> evenListByPeak = stream.filter(i -> i % 2 == 0).peek(System.out::println).collect(Collectors.toList());
        System.out.println(evenListByPeak);

        Stream<Integer> stream2 = Stream.of(1, 2, -3, 4, 5);
        stream2.filter(i -> i % 2 == 0).forEach(i -> System.out.print(i + " "));

        // short circuit operation
        boolean anyMatch = Stream.of(5, 10, 15, 20).anyMatch(i -> i % 3 == 0);
        boolean allMatch = Stream.of(5, 10, 15, 20).allMatch(i -> i % 3 == 0);
        boolean noneMatch = Stream.of(5, 10, 15, 20).noneMatch(i -> i % 3 == 0);

        System.out.println("\nanyMatch " + anyMatch);
        System.out.println("allMatch " + allMatch);
        System.out.println("noneMatch " + noneMatch);

        // findAny and findFirst
        // these are the short-circuit operations
        int findAny = Stream.of(5, 10, 15).filter(i -> i % 3 == 0).findAny().orElse(0);
        int findFirst = Stream.of(5, 10, 15, 20).filter(i -> i % 2 == 0).findFirst().get();

        System.out.println("findAny " + findAny);
        System.out.println("findFirst " + findFirst);

        // stream reduction
        int sum = Arrays.stream(arr).reduce(0, Integer::sum);
        int doubleSum = Arrays.stream(arr).reduce(1, (i1, i2) -> i1 * i2);

        System.out.println("sum " + sum);
        System.out.println("doubleSum " + doubleSum);

        // sorting based on values
        Function<String, Integer> function = str -> str.length();
        Stream.of("grapes", "milk", "pineapple", "water-melon")
                .sorted(Comparator.comparing(function))
                .forEach(System.out::print);

        Stream.of("grapes", "milk", "pineapple", "water-melon")
                .sorted(Comparator.comparing(String::length, Comparator.reverseOrder()))
                .forEach(System.out::print);

        getEmployees().stream()
                .sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getAge))
                .forEach(System.out::println);

    }

    private static List<Employee> getEmployees() {
        return List.of(new Employee("1", "Jagdish", 22),
                new Employee("5", "Madhur", 22),
                new Employee("4", "Harshal", 20),
                new Employee("7", "Tejas", 19),
                new Employee("3", "Kunal", 24),
                new Employee("2", "Jayant", 22),
                new Employee("6", "Pratik", 22),
                new Employee("8", "Jagdish", 19));
    }
}
