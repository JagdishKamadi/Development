package com.epam.controller;

import com.epam.entity.Department;
import com.epam.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/{id}")
    public Department GetDepartment(@PathVariable Long id) {
        return departmentService.getDepartment(id);
    }

    @GetMapping("/")
    public List<Department> getDepartments() {
        return departmentService.getDepartments();
    }

    @PostMapping("/")
    public Department save(@Valid @RequestBody Department department) {
        return departmentService.save(department);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return departmentService.delete(id);
    }

    @PutMapping("/{id}")
    public Department update(@PathVariable Long id, @Valid @RequestBody Department department) {
        return departmentService.update(id, department);
    }

}
