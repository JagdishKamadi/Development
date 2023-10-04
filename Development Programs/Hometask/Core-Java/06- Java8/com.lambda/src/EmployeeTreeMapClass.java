import com.interf.fun.*;
import java.util.*;

public class EmployeeTreeMapClass {
    public static void main(String[] args) {

        // create the object
        Map<Integer,Employee> employeeTreeMap = new TreeMap<>();

        // add values
        employeeTreeMap.put(101,new Employee("Jagdish",21));
        employeeTreeMap.put(102,new Employee("Madhur",22));
        employeeTreeMap.put(103,new Employee("Amit",19));
        employeeTreeMap.put(104,new Employee("Jayant",23));
        employeeTreeMap.put(105,new Employee("Kunal",22));
        employeeTreeMap.put(106,new Employee("Harshal",20));
        employeeTreeMap.put(107,new Employee("Darshan",22));
        employeeTreeMap.put(108,new Employee("Tejas",24));

        // now create the list entry
        List<Map.Entry<Integer,Employee>> entryList = new ArrayList<>(employeeTreeMap.entrySet());

        // now use comparator
        Comparator<Map.Entry<Integer,Employee>> comp =(e1,e2)->
        {
            // sort the value [ name in values in reversed order ]
            return e2.getValue().getName()
                    .compareTo(e1.getValue().getName());
        };

        // sort the list now
        entryList.sort(comp);

        // to store in new map
        // use LinkedHashMap to maintain order of insertion
        Map<Integer,Employee> newEmployeeMap = new LinkedHashMap<>();

        // store the value in new LinkedHashMap
        for(Map.Entry<Integer,Employee> entry:entryList)
        {
            newEmployeeMap.put(entry.getKey(),entry.getValue());
        }

        // print the values
        System.out.println(newEmployeeMap);
    }
}
