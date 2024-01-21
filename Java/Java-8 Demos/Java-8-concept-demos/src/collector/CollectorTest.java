package collector;

import stream.Employee;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorTest {
    public static void main(String[] args) {
        List<Employee> employeeSet = getEmployees();
        String xmlFormat = employeeSet.parallelStream()
                .sorted(Comparator.comparing(Employee::getId).thenComparing(Employee::getName).thenComparing(Employee::getAge))
                .collect(new ToXMLCollector());
//        System.out.println(xmlFormat);


        // collectors test
        List<String> stringList = Stream.of("java", ".net", "python")
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(stringList);

        Map<String, Integer> result = Stream.of("java", ".net", "python")
                .collect(Collectors.toMap(String::toUpperCase, String::length));
        System.out.println(result);

        Map<String, Integer> result2 = Stream.of("java", ".net", "python", "JaVa")
                .collect(Collectors.toMap(String::toUpperCase, String::length, (value1, value2) -> value1));
        System.out.println(result2);

        String resultString = Stream.of("java", ".net", "python")
                .collect(Collectors.joining(" | ", "Result string : [ ", "]"));
        System.out.println(resultString);

        // grouping example

        Map<Integer, List<Employee>> groupListByAge = getEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getAge));
        System.out.println(groupListByAge);

        Map<Integer, Map<String, List<Employee>>> groupListByAgeAndThenName = getEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getAge, Collectors.groupingBy(Employee::getName)));
        System.out.println(groupListByAgeAndThenName);

        Map<Integer, Long> groupListCount = getEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getAge, Collectors.counting()));
        System.out.println(groupListCount);

        Map<Boolean, List<Employee>> booleanListMap = getEmployees().stream()
                .collect(Collectors.partitioningBy(e -> e.getAge() == 22));
        System.out.println(booleanListMap);


        // Optional class demo
        Optional<String> stringOptional = getEmployees().stream()
                .filter(e -> e.getAge() == 29)
                .findAny()
                .map(Employee::getName);
        System.out.println(stringOptional.orElse(null));
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
