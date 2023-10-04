package com.epam.service;

import com.epam.exception.EmployeeNotFoundException;
import com.epam.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private List<Employee> employeeList = new ArrayList<>();
    public EmployeeService()
    {
        employeeList.addAll(List.of(new Employee("Jagdish","Kamadi",21),
                        new Employee("Kunal","Karwatkar",22),
                        new Employee("Madhur","Bhoyar",23))
                );
    }

    public List<Employee> getEmployees()
    {
        return this.employeeList;
    }

    public Employee getEmployee(String firstName)
    {
        return this.employeeList.stream()
                .filter(employee -> employee.getFirstName().equalsIgnoreCase(firstName))
                .findAny()
                .orElseThrow(()->new EmployeeNotFoundException("Employee not found for firstname : "+firstName));
    }

    public  Employee saveEmployee(Employee employee)
    {
        this.employeeList.add(employee);
        return  employee;
    }

}
