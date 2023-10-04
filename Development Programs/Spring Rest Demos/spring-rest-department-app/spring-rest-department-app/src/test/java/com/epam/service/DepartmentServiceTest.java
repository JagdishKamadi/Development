package com.epam.service;

import com.epam.entity.Department;
import com.epam.exception.DepartmentNotFoundException;
import com.epam.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

import java.util.*;

@ExtendWith({MockitoExtension.class})
class DepartmentServiceTest {

    private Department inputDepartment;
    private Department outputDepartment;

    @Mock
    private DepartmentRepository departmentRepository;

    @InjectMocks
    private DepartmentServiceImpl departmentService;

    @BeforeEach
    void setUp() {
        inputDepartment = Department.builder()
                .name("CSE")
                .address("Near Workshop")
                .code("CSE-01")
                .build();

        outputDepartment = Department.builder()
                .id(1l)
                .name("CSE")
                .address("Near Workshop")
                .code("CSE-01")
                .build();
    }

    @Test
    public void Save_Success() throws Exception {
        when(departmentRepository.save(any(Department.class))).thenReturn(outputDepartment);
        assertNotNull(departmentService.save(inputDepartment));
    }


    @Nested
    class GetDepartmentTestClass {

        @Test
        public void GetDepartment_Success_When_Valid_Id() throws Exception {
            when(departmentRepository.findById(anyLong())).thenReturn(Optional.of(outputDepartment));

            assertAll("This method should pass for valid department id",
                    () -> departmentService.getDepartment(1l),
                    () -> departmentService.getDepartment(1l));
        }

        @Test
        public void GetDepartment_Throws_Exception_When_Invalid_Id() throws Exception {
            when(departmentRepository.findById(anyLong())).thenReturn(Optional.empty());
            assertThrows(DepartmentNotFoundException.class, () -> departmentService.getDepartment(anyLong()));
        }
    }

    @Test
    public void GetDepartment_Success() {
        List<Department> departmentList = List.of(inputDepartment, outputDepartment);
        when(departmentRepository.findAll()).thenReturn(departmentList);
        assertNotNull(departmentService.getDepartments());
    }

    @Nested
    class DeleteDepartmentTestClassUsingVerify {

        @Test
        public void Delete_Success_When_Valid_Id() {
            when(departmentRepository.findById(anyLong())).thenReturn(Optional.of(outputDepartment));
            departmentRepository.deleteById(anyLong());
            verify(departmentRepository, Mockito.times(1)).deleteById(anyLong());
            assertEquals("Department deleted successfully for id 1", departmentService.delete(1l));
        }

        @Test
        public void Delete_Throws_Exception_When_Invalid_Id() {
            when(departmentRepository.findById(anyLong())).thenThrow(DepartmentNotFoundException.class);
            assertThrows(DepartmentNotFoundException.class, () -> departmentService.delete(anyLong()));
        }
    }

    @Nested
    class DeleteDepartmentTestClassUsingDoNothing {
        @Test
        public void Delete_Success_When_Valid_Id() {
            when(departmentRepository.findById(anyLong())).thenReturn(Optional.of(outputDepartment));
            doNothing().when(departmentRepository).deleteById(anyLong());
            departmentService.delete(anyLong());
            assertEquals("Department deleted successfully for id 0", departmentService.delete(anyLong()));
        }
    }

    @Nested
    class UpdateDepartmentTestClass {
        @Test
        public void Update_When_Department_Id_Is_Valid() {
            when(departmentRepository.findById(anyLong())).thenReturn(Optional.of(outputDepartment));
            when(departmentRepository.save(any(Department.class))).thenReturn(outputDepartment);
            assertNotNull(departmentService.update(anyLong(), inputDepartment));
        }

        @Test
        public void Update_Throws_Exception_When_Department_Id_Is_Invalid() {
            doThrow(DepartmentNotFoundException.class).when(departmentRepository).findById(anyLong());
            assertThrows(DepartmentNotFoundException.class, () -> departmentService.update(anyLong(), inputDepartment));
        }
    }
}