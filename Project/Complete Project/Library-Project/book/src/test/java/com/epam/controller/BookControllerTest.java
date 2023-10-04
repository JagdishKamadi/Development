package com.epam.controller;

import com.epam.dto.BookDTO;
import com.epam.model.Book;
import com.epam.service.BookService;
import com.fasterxml.jackson.core.JsonProcessingException;
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
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
class BookControllerTest {

    @MockBean
    private BookService bookService;

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private BookController bookController;

    private ObjectMapper objectMapper;
    private BookDTO bookDTO;
    private Book book;

    private String bookDataJSON;

    @BeforeEach
    void setUpObject() throws JsonProcessingException {
        objectMapper = new ObjectMapper();


        bookDTO = new BookDTO();
        bookDTO.setBookId(1);
        bookDTO.setBookName("Drilling in C");
        bookDTO.setPrice(2000d);
        bookDTO.setPublisher("Gandhi Book Depo,Wardha");
        bookDTO.setAuthor("Rajesh Ingale");

        bookDataJSON = objectMapper.writeValueAsString(bookDTO);

        book = new Book();
        book.setBookId(1);
        book.setBookName("Drilling in C");
        book.setPrice(2000d);
        book.setPublisher("Gandhi Book Depo,Wardha");
        book.setAuthor("Rajesh Ingale");
    }

    @Test
    void test_getBooks() throws Exception
    {
        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders
                                            .get("/books"))
                                            .andReturn();
        int status = result.getResponse().getStatus();
        assertEquals(200,status);
    }

    @Test
    void test_getBook() throws Exception
    {
        String uri = "/books/{book_id}";
        when(bookService.getBook(anyInt())).thenReturn(bookDTO);
        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get(uri,anyInt()))
                .andReturn();

        int status = result.getResponse().getStatus();
        assertEquals(200,status);
    }

    @Test
    void test_saveBook() throws Exception
    {
        String uri = "/books";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(uri)
                .accept(MediaType.APPLICATION_JSON)
                .content(bookDataJSON)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        int status = result.getResponse().getStatus();
        assertEquals(201,status);
    }

    @Test
    void test_deleteBook() throws Exception
    {
        String uri = "/books/{book_id}";
        MvcResult result = this.mockMvc.
                perform(MockMvcRequestBuilders.delete(uri,anyInt()))
                .andReturn();
        int status = result.getResponse().getStatus();
        assertEquals(200,status);
    }


    @Test
    void test_updateBook() throws Exception
    {
        String uri = "/books/{book_id}";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.put(uri,anyInt())
                .accept(MediaType.APPLICATION_JSON)
                .content(bookDataJSON)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        int status = result.getResponse().getStatus();
        assertEquals(200,status);
    }
}
