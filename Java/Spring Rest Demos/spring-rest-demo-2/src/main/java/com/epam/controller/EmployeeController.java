package com.epam.controller;

import com.epam.entity.Employee;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// we have set the base url also
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee)
    {
        return employee;
    }
}

