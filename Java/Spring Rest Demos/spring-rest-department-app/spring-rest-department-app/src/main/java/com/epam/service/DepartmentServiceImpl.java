package com.epam.service;

import com.epam.entity.Department;
import com.epam.exception.DepartmentNotFoundException;
import com.epam.repository.DepartmentRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Lazy(value = false)
public class DepartmentServiceImpl implements DepartmentService {

    private static final Logger LOGGER = LogManager.getLogger(DepartmentServiceImpl.class);
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department getDepartment(Long id) {
        return departmentRepository.findById(id).orElseThrow(() -> new DepartmentNotFoundException("Department not found for id " + id));
    }

    @Override
    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public String delete(Long id) {
        departmentRepository.findById(id).orElseThrow(() -> new DepartmentNotFoundException("Department not found for id " + id));
        departmentRepository.deleteById(id);
        return "Department deleted successfully for id " + id;
    }

    @Override
    public Department update(Long id, Department department) {
        Department updateDepartmentData = departmentRepository.findById(id).orElseThrow(() -> new DepartmentNotFoundException("Department not found for id " + id));

        if (department.getName() != null && !department.getName().isBlank()) {
            updateDepartmentData.setName(department.getName());
        }

        if (department.getAddress() != null && !department.getAddress().isBlank()) {
            updateDepartmentData.setAddress(department.getAddress());
        }

        if (department.getCode() != null && !department.getCode().isBlank()) {
            updateDepartmentData.setCode(department.getCode());
        }

        return departmentRepository.save(updateDepartmentData);
    }
}
