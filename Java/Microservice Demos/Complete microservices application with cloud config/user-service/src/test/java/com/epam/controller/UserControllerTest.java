package com.epam.controller;

import com.epam.service.UserService;
import com.epam.valueobject.Department;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.epam.model.*;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@EnableAutoConfiguration
class UserControllerTest {

    @MockBean
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;

    private User user;
    private Department department;
    private String userDataJSON;

    @BeforeEach
    void setUpObject() throws Exception
    {
        user = new User();
        user.setFirstName("Jagdish");
        user.setLastName("Kamadi");
        user.setEmailId("jagadishkamadi@gmail.com");
        user.setDepartmentId(1);

        department = Department.builder()
                .departmentName("Computer Science Engineering")
                .departmentAddress("Infront of library")
                .departmentCode("CSE-104")
                .build();

        ObjectMapper objectMapper = new ObjectMapper();
        userDataJSON = objectMapper.writeValueAsString(user);
    }

    @Test
    void test_saveUser_success() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users")
                .accept(MediaType.APPLICATION_JSON)
                .content(userDataJSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    void getUserWithDepartment() {
    }
}