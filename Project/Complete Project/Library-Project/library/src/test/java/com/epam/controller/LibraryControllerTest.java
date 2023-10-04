package com.epam.controller;

import com.epam.client.BookClient;
import com.epam.client.UserClient;
import com.epam.dto.BookDTO;
import com.epam.dto.LibraryDTO;
import com.epam.dto.UserDTO;
import com.epam.service.LibraryServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class LibraryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    BookClient bookClient;

    @MockBean
    UserClient userClient;

    @MockBean
    LibraryServiceImpl libraryServiceImpl;

    BookDTO bookDto;
    List<BookDTO> bookList = new ArrayList<>();

    UserDTO userDto;
    List<UserDTO> userList = new ArrayList<>();

    LibraryDTO libraryDto;

    ObjectMapper objectMapper;

    @BeforeEach
    void bookSetup() {
        objectMapper = new ObjectMapper();
        libraryDto = new LibraryDTO();
        libraryDto.setLibraryId(1);
        libraryDto.setUsername("Jagdish");
        libraryDto.setBookId(1);
    }

    @Test
    void test_getBooks() throws Exception {
        when(bookClient.getBooks()).thenReturn(bookList);

        mockMvc.perform(get("/library/books")).andExpect(status().isOk());

    }

    @Test
    void test_getBook() throws Exception {
        when(bookClient.getBook(1)).thenReturn(bookDto);

        mockMvc.perform(get("/library/books/1")).andExpect(status().isOk());

    }

    @Test
    void test_addBook() throws Exception {
        String str = objectMapper.writeValueAsString(bookDto);
        when(bookClient.addBook(bookDto)).thenReturn(bookDto);

        mockMvc.perform(post("/library/books").contentType(MediaType.APPLICATION_JSON).content(str)).andExpect(status().isOk());
    }

    @Test
    void test_updateBook() throws Exception {

        String str = objectMapper.writeValueAsString(bookDto);
        when(bookClient.addBook(bookDto)).thenReturn(bookDto);

        mockMvc.perform(put("/library/books").contentType(MediaType.APPLICATION_JSON).content(str)).andExpect(status().isOk());
    }

    @Test
    void test_deleteBook() throws Exception {

        doNothing().when(bookClient).deleteBook(1);
        bookClient.deleteBook(1);
        verify(bookClient).deleteBook(1);
        mockMvc.perform(delete("/library/books/1")).andExpect(status().isOk());

    }

    @Test
    void test_getUsers() throws Exception {

        when(userClient.getUsers()).thenReturn(userList);

        mockMvc.perform(get("/library/users")).andExpect(status().isOk());

    }

    @Test
    void test_getUser() throws Exception {

        when(userClient.getUser(anyString())).thenReturn(userDto);

        mockMvc.perform(get("/library/users", anyString())).andExpect(status().isOk());

    }

    @Test
    void test_addUser() throws Exception {
        String str = objectMapper.writeValueAsString(userDto);
        when(userClient.addUser(userDto)).thenReturn(userDto);
        mockMvc.perform(post("/library/users").contentType(MediaType.APPLICATION_JSON).content(str)).andExpect(status().isOk());
    }

    @Test
    void test_updateUser() throws Exception {
        String str = objectMapper.writeValueAsString(userDto);
        when(userClient.addUser(userDto)).thenReturn(userDto);
        mockMvc.perform(put("/library/users").contentType(MediaType.APPLICATION_JSON).content(str)).andExpect(status().isOk());
    }

    @Test
    void test_deleteUser() throws Exception {

        doNothing().when(userClient).deleteUser(anyString());
        bookClient.deleteBook(1);
        verify(bookClient).deleteBook(1);
        mockMvc.perform(delete("/library/books/1")).andExpect(status().isOk());
    }

    @Test
    void test_issueBook() throws Exception
    {
        String uri = "/library/users/Jagdish/books/1";
        this.mockMvc.perform(post(uri)).andExpect(status().isCreated());
    }

    @Test
    void test_releaseBook() throws Exception
    {
        String uri = "/library/users/Jagdish/books/1";
        this.mockMvc.perform(delete(uri)).andExpect(status().isOk());
    }
}