package com.epam.quiz.controller;

import com.epam.quiz.dto.UserDTO;
import com.epam.quiz.model.User;
import com.epam.quiz.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/* Completed all test cases */
@SpringBootTest
@AutoConfigureMockMvc
class AdminLoginControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserService userService;

    @InjectMocks
    private AdminLoginControllerTest admin;

    @Test
     void adminLoginSuccessTest() throws Exception {
        when(userService.isUserLogin(any(UserDTO.class))).thenReturn(true);

        mockMvc.perform(post("/admin/adminlogin")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("username", "Admin")
                        .param("mailId", "admin@gmail.com")
                        .param("password", "Admin@00"))
                .andExpect(view().name("adminpages/adminpage"));
    }

    @Test
     void adminLoginFailTest() throws Exception {
        when(userService.isUserLogin(any(UserDTO.class))).thenReturn(false);

        mockMvc.perform(post("/admin/adminlogin")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("username", "Admin")
                        .param("mailId", "admin@gmail.com")
                        .param("password", "Admin@01"))
                .andExpect(view().name("nullpage"));
    }

}

