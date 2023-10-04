package com.epam.quiz.controller;

import com.epam.quiz.dto.UserDTO;
import com.epam.quiz.service.UserService;
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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
class UserLoginControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @InjectMocks
    private UserLoginController userLoginController;

    private String userDTOJSON;
    private UserDTO userDTO;

    @BeforeEach
    void setUpObjectBeforeEach()
    {
        userDTOJSON = " {\n" +
                "    \"username\" : \"Jagdish\",\n" +
                "    \"typeOfUser\" : 2,\n" +
                "    \"password\" : \"Jagdish@99\"\n" +
                "}";

        userDTO  = new UserDTO();
        userDTO.setUsername("Jagdish");
        userDTO.setTypeOfUser(2);
        userDTO.setPassword("Jagdish@99");
    }

    @Test
    void test_loginValid() throws Exception
    {
        String uri = "/users/login";

        MvcResult result =  this.mockMvc.perform(post(uri)
                .content(userDTOJSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        int status = result.getResponse().getStatus();
        assertEquals(200,status);
        String content = result.getResponse().getContentAsString();
        assertEquals("User login successfully",content);
    }


    // another way to do test using MockMvcRequestBuilders
    @Test
    void test_registerSuccess() throws Exception
    {
        String uri = "/users/register";
        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .content(userDTOJSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        int status = result.getResponse().getStatus();
        assertEquals(201,status);
        String content = result.getResponse().getContentAsString();
        assertEquals("User created successfully",content);
    }

}
