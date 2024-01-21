import com.interf.fun.*;
import java.util.*;
public class EmployeeSortByNameList {
    public static void main(String[] args) {

        // create the list
        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee("Madhur",21));
        employeeList.add(new Employee("Jagdish",22));
        employeeList.add(new Employee("Amit",20));
        employeeList.add(new Employee("Kunal",20));
        employeeList.add(new Employee("Jayant",19));
        employeeList.add(new Employee("Harshal",23));

        // use comparator interface here
        // use this way
        //  it is called anonymous class
        Comparator<Employee> com = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o2.getName().compareTo(o1.getName());
            }
        };

        // or this way both are valid
        // it is called lambda expression
        Comparator<Employee> lambdaCom = (e1,e2)->
        {
            return e2.getName().compareTo(e1.getName());
        };

        Collections.sort(employeeList,lambdaCom);
        System.out.println(employeeList);

        Comparator<Employee> comEmp = new Comparator<Employee>()
        {
            public int compare(Employee e1,Employee e2)
            {
                return e2.getName().compareTo(e1.getName());
            }
        };

        Comparator<Employee> compEm2 = (e1,e2)->{
          return e2.getName().compareTo(e1.getName());
        };
    }
}
