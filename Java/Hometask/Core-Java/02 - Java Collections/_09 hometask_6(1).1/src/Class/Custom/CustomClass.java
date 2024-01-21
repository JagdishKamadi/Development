package Class.Custom;

import java.util.Scanner;
import java.util.*;

public class CustomClass {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in))
        {
            Map<Integer, Employee> employeesMap = new HashMap<>();
            employeesMap.put(100, new Employee(100,"Jagdish",44000d,"O+"));
            employeesMap.put(101, new Employee(101, "Madhur",38000d,"AB+"));
            employeesMap.put(102, new Employee(102, "Harshal", 80000d,"B-"));
            employeesMap.put(103, new Employee(103, "Jayant", 25000d,"A+"));

            Iterator<Integer> it = employeesMap.keySet().iterator();

            while(it.hasNext())
            {
                Integer key = it.next();
                System.out.print("[ Id : "+employeesMap.get(key).getId());
                System.out.print("  |   Name : "+employeesMap.get(key).getName());
                System.out.print("  |   Salary : "+employeesMap.get(key).getSalary());
                System.out.print("  |   BloodGroup : "+employeesMap.get(key).getBloodGroup()+"  ]\n");
            }

            //  using to toString method
//            System.out.println(employeesMap);

        }
    }
}
