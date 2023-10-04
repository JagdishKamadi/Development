package com.epam.departmentservice.controller;

import com.epam.departmentservice.exception.DepartmentNotFoundException;
import com.epam.departmentservice.model.Department;
import com.epam.departmentservice.service.DepartmentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.persistence.Access;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

@SpringBootTest
@AutoConfigureMockMvc
class DepartmentControllerTest {

    @MockBean
    private DepartmentService departmentService;

    @InjectMocks
    private DepartmentController departmentController;

    @Autowired
    private MockMvc mockMvc;
    private Department department;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        department = Department.builder()
                .departmentName("Computer Science Engineering")
                .departmentAddress("Infront of Library")
                .departmentCode("CSE-1024")
                .build();

        objectMapper = new ObjectMapper();
    }

    @Test
    void test_saveDepartment_success() throws Exception {
        String departmentDataJSON = objectMapper.writeValueAsString(department);

        String uri = "/departments/";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(uri)
                .accept(MediaType.APPLICATION_JSON)
                .content(departmentDataJSON)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        int status = result.getResponse().getStatus();
        assertEquals(201,status);
    }

    @Test
    void test_getDepartment_success() throws Exception{
        MvcResult result = this.mockMvc
                .perform(MockMvcRequestBuilders.get("/departments/{department_id}",anyInt()))
                .andReturn();

        int status = result.getResponse().getStatus();
        assertEquals(302,status);
    }

}