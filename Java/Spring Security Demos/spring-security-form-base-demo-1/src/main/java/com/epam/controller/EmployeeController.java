package com.epam.controller;

import com.epam.model.Employee;
import com.epam.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping
    public ResponseEntity<List<Employee>> getEmployees()
    {
        return new ResponseEntity<>(employeeService.getEmployees(),HttpStatus.OK);
    }

    @GetMapping("/{first_name}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("first_name") String firstName)
    {
        return ResponseEntity.ok(employeeService.getEmployee(firstName));
    }

    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee)
    {
        return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }
}
