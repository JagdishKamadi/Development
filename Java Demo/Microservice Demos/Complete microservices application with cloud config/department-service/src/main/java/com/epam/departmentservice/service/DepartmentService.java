package com.epam.departmentservice.service;

import com.epam.departmentservice.model.Department;

public interface DepartmentService {
    Department saveDepartment(Department department);
    Department getDepartment(Integer departmentId);
}
