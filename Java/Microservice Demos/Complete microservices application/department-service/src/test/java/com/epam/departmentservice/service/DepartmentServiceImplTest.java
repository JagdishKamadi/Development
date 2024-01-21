package com.epam.departmentservice.service;

import com.epam.departmentservice.exception.DepartmentNotFoundException;
import com.epam.departmentservice.model.Department;
import com.epam.departmentservice.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {


    @Mock
    private DepartmentRepository departmentRepository;

    @InjectMocks
    private DepartmentServiceImpl departmentService;

    private Department department;

    @BeforeEach
    void setUpObject()
    {
        department = Department.builder()
                .departmentName("Computer Science Engineering")
                .departmentAddress("Infront of Library")
                .departmentCode("CSE-1024")
                .build();
    }

    @Test
    void test_saveDepartment_success() {

        when(departmentRepository.save(department)).thenReturn(department);
        assertNotNull(departmentService.saveDepartment(department));

    }

    @Test
    void test_getDepartment_success() {
     when(departmentRepository.findById(anyInt())).thenReturn(Optional.ofNullable(department));
        assertNotNull(departmentService.getDepartment(anyInt()));
    }

    @Test
    void test_getDepartment_error()
    {
        when(departmentRepository.findById(anyInt())).thenThrow(DepartmentNotFoundException.class);
        assertThrows(DepartmentNotFoundException.class,()->departmentService.getDepartment(anyInt()));
    }
}