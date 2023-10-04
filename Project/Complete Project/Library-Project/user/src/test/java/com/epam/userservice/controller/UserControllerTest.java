package com.epam.userservice.controller;

import com.epam.controller.UserController;
import com.epam.dto.UserDTO;
import com.epam.service.UserService;
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
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @InjectMocks
    private UserController userController;

    private UserDTO userDTO;
    private ObjectMapper objectMapper;

    private String userDTOJSON;

    @BeforeEach
    void setUpObject() throws Exception
    {
        userDTO = new UserDTO();
        userDTO.setUserId(1);
        userDTO.setUsername("Jagdish");
        userDTO.setMailId("jagadishkamadi@gmail.com");
        userDTO.setPassword("Jagdish@99");

        objectMapper = new ObjectMapper();
        userDTOJSON = objectMapper.writeValueAsString(userDTO);
    }

    @Test
    void test_getUsers() throws  Exception
    {
        String uri = "/users";
        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders
                                        .get(uri))
                                        .andReturn();
        int status = result.getResponse().getStatus();
        assertEquals(200,status);
    }

    @Test
    void test_getUser() throws Exception
    {
        String uri = "/users/{username}";
        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders
                        .get(uri,anyString()))
                .andReturn();
        int status = result.getResponse().getStatus();
        assertEquals(200,status);
    }

    @Test
    void test_addUser() throws Exception
    {
        String uri = "/users";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(uri)
                .accept(MediaType.APPLICATION_JSON)
                .content(userDTOJSON)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = this.mockMvc.perform(requestBuilder).andReturn();

        int status = result.getResponse().getStatus();
        assertEquals(201,status);
    }

    @Test
    void test_deleteUser() throws Exception
    {
        String uri = "/users/{username}";
        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders
                        .delete(uri,"Jagdish"))
                        .andReturn();
        int status = result.getResponse().getStatus();
        assertEquals(200,status);
    }

    @Test
    void test_updateUser() throws Exception
    {
        String uri = "/users";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.put(uri)
                .accept(MediaType.APPLICATION_JSON)
                .content(userDTOJSON)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = this.mockMvc.perform(requestBuilder).andReturn();

        int status = result.getResponse().getStatus();
        assertEquals(200,status);
    }
}
