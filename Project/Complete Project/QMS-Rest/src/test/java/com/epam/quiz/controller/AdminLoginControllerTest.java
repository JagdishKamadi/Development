package com.epam.quiz.controller;

import com.epam.quiz.converter.QuestionConverter;
import com.epam.quiz.dto.UserDTO;
import com.epam.quiz.exception.QuestionNotFoundException;
import com.epam.quiz.exception.UserNotFoundException;
import com.epam.quiz.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.jwt;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
class AdminLoginControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @InjectMocks
    private AdminLoginController adminLoginController;

    @Autowired
    private QuestionConverter questionConverter;
    private UserDTO userDTO;

    private  ObjectMapper mapper;

    @BeforeEach
    void setUpObjectBeforeEach()
    {
        mapper = new ObjectMapper();
        userDTO  = new UserDTO();
        userDTO.setUsername("Admin");
        userDTO.setPassword("Admin@00");
    }

    @Test
    void  test_adminLoginValid() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String dataJSON = mapper.writeValueAsString(userDTO);
        doNothing().when(userService).userLogin(userDTO);
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/admin")
                .content(dataJSON)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        assertEquals(200,result.getResponse().getStatus());
        String content = result.getResponse().getContentAsString();
        assertEquals("Admin login successfully",content);
    }

}
