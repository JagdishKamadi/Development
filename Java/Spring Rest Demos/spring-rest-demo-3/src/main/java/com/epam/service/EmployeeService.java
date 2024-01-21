package com.epam.service;

import com.epam.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee getEmployee(Integer id);
    public List<Employee> getEmployees();
    public Employee saveEmployee(Employee employee);
    public Employee updateEmployee(Employee employee);
    public void deleteEmployee(Integer id);
}
