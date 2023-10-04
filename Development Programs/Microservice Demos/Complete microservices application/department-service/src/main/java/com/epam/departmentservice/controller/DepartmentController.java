package com.epam.departmentservice.controller;

import com.epam.departmentservice.model.Department;
import com.epam.departmentservice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    public ResponseEntity<Department> saveDepartment(@RequestBody Department department)
    {
        return new ResponseEntity<>(departmentService.saveDepartment(department), HttpStatus.CREATED);
    }


    @GetMapping("/{department_id}")
    public ResponseEntity<Department> getDepartment(@PathVariable("department_id") Integer departmentId)
    {
        return new ResponseEntity<>(departmentService.getDepartment(departmentId),HttpStatus.FOUND);
    }
}
