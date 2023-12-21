package optional;

import stream.Employee;
import utility.EmployeeData;

import java.util.Optional;

public class OptionalTest {


    public static void main(String[] args) {

        Optional<Integer> optionalAge = EmployeeData.getEmployees().stream()
                .filter(e -> e.getName().startsWith("J"))
                .findFirst()
                .map(Employee::getAge);
        System.out.println("Age " + optionalAge.orElse(21));

    }
}
