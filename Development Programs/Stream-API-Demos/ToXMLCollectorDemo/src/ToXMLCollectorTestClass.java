import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ToXMLCollectorTestClass {
    public static void main(String[] args) {
        Set<Employee> employeeSet = new HashSet<>();
        employeeSet.add(new Employee("1", "Jagdish", "Java", 200000));
        employeeSet.add(new Employee("2", "Madhur", "Python", 240000D));
        employeeSet.add(new Employee("2", "Kunal", "Python", 240000D));
        employeeSet.add(new Employee("3", "Jayant", "HTML", 330000D));
        employeeSet.add(new Employee("4", "Harshal", ".Net", 180000D));
        employeeSet.add(new Employee("4", "Pravin", ".Net", 180000D));

        String xmlstr = employeeSet.parallelStream().sorted((e1, e2) -> e1.empId.compareTo(e2.empId)).collect(new ToXMLCollector());
        System.out.println(xmlstr);



    }
}