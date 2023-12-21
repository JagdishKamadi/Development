package com.epam.controller;

import com.epam.entity.Department;
import com.epam.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DepartmentControllerTest {

    private Department inputDepartment;
    private Department outputDepartment;

    private static final String URI = "/department/";
    @InjectMocks
    private DepartmentController departmentController;
    @MockBean
    private DepartmentService departmentService;

    @Autowired
    private MockMvc mockMvc;


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

    @Nested
    class GetDepartmentTestClass {
        @Test
        public void GetDepartment_Success_When_Id_Is_Valid() throws Exception {
            MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/department/{id}", anyLong()))
                    .andReturn();

            int status = result.getResponse().getStatus();
            assertEquals(200, status);
        }

//        @Test
//        public void GetDepartment_Success_When_Id_Is_Invalid() throws Exception {
//            MvcResult result = mockMvc
//                    .perform(MockMvcRequestBuilders.get("/department/{id}", anyLong())
//                            .content(String.valueOf(MediaType.APPLICATION_JSON)))
//                    .andExpect(status().isNotFound())
//                    .andReturn();
//
//            int status = result.getResponse().getStatus();
//            assertEquals(404, status);
//        }
    }


}