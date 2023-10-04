package utility;

import stream.Employee;

import java.util.List;

public class EmployeeData {

    public static List<Employee> getEmployees() {
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
