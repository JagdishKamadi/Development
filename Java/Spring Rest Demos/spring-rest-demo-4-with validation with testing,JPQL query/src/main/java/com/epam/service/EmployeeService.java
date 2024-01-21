package com.epam.service;

import com.epam.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee getEmployee(Integer id);
    List<Employee> getEmployees();
    Employee saveEmployee(Employee employee);
    Employee updateEmployee(Employee employee);
    void deleteEmployee(Integer id);
    List<Employee> getEmployeesByName(String name);
    List<Employee> getEmployeesByNameAndDepartment(String name,String department);
    List<Employee> getEmployeeNameByContaining(String pattern);
    List<Employee> getNameContainingWithValidAge(String pattern,Integer age);
    Integer deleteEmployeeByName(String name);

}
