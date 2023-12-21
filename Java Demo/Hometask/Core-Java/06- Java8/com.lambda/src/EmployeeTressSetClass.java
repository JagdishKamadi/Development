/* Problem Statement
    Create a TreeSet that sorts the given set of
    Employees in the alphabetic order of their name
 */

import java.util.*;
import com.interf.fun.*;

public class EmployeeTressSetClass {
    public static void main(String[] args) {

        // lambda expression for sorting name of employees
        ComparatorInterfaceForEmployee compTest = (emp1,emp2)->
        {
            return emp1.getName().compareTo(emp2.getName());
        };

        // create the treeset
        // which receive employee object
        TreeSet<Employee> treeSet = new TreeSet<>(compTest);

        // adding value
        treeSet.add(new Employee("Jagdish",21));
        treeSet.add(new Employee("Madhur",22));
        treeSet.add(new Employee("Amit",19));
        treeSet.add(new Employee("Jayant",23));
        treeSet.add(new Employee("Kunal",22));
        treeSet.add(new Employee("Harshal",20));
        treeSet.add(new Employee("Darshan",22));
        treeSet.add(new Employee("Tejas",24));

        // print the result
        System.out.println(treeSet);
    }
}
