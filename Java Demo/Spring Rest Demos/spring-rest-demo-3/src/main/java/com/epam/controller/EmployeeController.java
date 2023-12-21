package com.epam.controller;

import com.epam.entity.Employee;
import com.epam.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// we have set the base url also
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Integer id)
    {
        return employeeService.getEmployee(id);
    }

    @GetMapping("/")
    public List<Employee> getEmployees()
    {
        return employeeService.getEmployees();
    }

    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee)
    {
        return employeeService.saveEmployee(employee);
    }

    @PutMapping("/{employee_id}")
    public Employee updateEmployee(@PathVariable("employee_id") Integer employeeId,@RequestBody Employee employee)
    {
        employee.setId(employeeId);
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Integer id)
    {
        employeeService.deleteEmployee(id);
        return "Employee deleted for id "+id;
    }
}

