package com.epam.departmentservice.service;

import com.epam.departmentservice.exception.DepartmentNotFoundException;
import com.epam.departmentservice.model.Department;
import com.epam.departmentservice.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department getDepartment(Integer departmentId) {
        log.info("Inside getDepartment pass 1");
        return departmentRepository.findById(departmentId).orElseThrow(()->new DepartmentNotFoundException("Department not found for id "+departmentId));
    }
}
