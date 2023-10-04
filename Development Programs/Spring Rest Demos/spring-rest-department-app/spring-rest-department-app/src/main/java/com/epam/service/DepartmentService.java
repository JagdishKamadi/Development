package com.epam.service;

import com.epam.entity.Department;

import java.util.*;

public interface DepartmentService {

    Department save(Department department);

    Department getDepartment(Long id);

    List<Department> getDepartments();

    String delete(Long id);

    Department update(Long id, Department department);
}
