/*  problem Statement
    Create a TreeSet that sorts the given set of
    Employees in the alphabetic order of their name
 */
import java.util.*;
import com.interf.fun.*;

public class StringComparatorInterfaceTest {
    public static void main(String[] args) {

        // list to store name and age
        List<Employee> list = new ArrayList();

        // adding value
        list.add(new Employee("Jagdish",21));
        list.add(new Employee("Madhur",22));
        list.add(new Employee("Amit",19));
        list.add(new Employee("Jayant",23));
        list.add(new Employee("Kunal",22));
        list.add(new Employee("Harshal",20));
        list.add(new Employee("Darshan",22));
        list.add(new Employee("Tejas",24));

        // lambda expression
        ComparatorInterfaceForEmployee compTest = (emp1, emp2)->
        {
            // only using compareTo we can sort the string value
            return emp1.getName().compareTo(emp2.getName());
        };

        // pass the interface object
        Collections.sort(list,compTest);

        // final result
        System.out.println(list);

    }
}

