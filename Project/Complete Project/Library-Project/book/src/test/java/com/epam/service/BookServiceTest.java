package com.epam.service;

import com.epam.converter.BookConverter;
import com.epam.dto.BookDTO;
import com.epam.exception.BookNotFoundException;
import com.epam.model.Book;
import com.epam.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith({MockitoExtension.class})
class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @Mock
    private BookConverter bookConverter;

    @InjectMocks
    private BookServiceImpl bookService;

    private BookDTO bookDTO;
    private Book book;

    @BeforeEach
    private void setUpObject()
    {
        bookDTO = new BookDTO();
        bookDTO.setBookId(1);
        bookDTO.setBookName("Drilling in C");
        bookDTO.setPrice(2000d);
        bookDTO.setPublisher("Gandhi Book Depo,Wardha");
        bookDTO.setAuthor("Rajesh Ingale");

        book = new Book();
        book.setBookId(1);
        book.setBookName("Drilling in C");
        book.setPrice(2000d);
        book.setPublisher("Gandhi Book Depo,Wardha");
        book.setAuthor("Rajesh Ingale");
    }

    @Test
    void test_getBooksSuccess()
    {
        when(bookRepository.findAll()).thenReturn(new ArrayList<Book>());
        assertNotNull(bookService.getBooks());
    }

    @Test
    void test_getBookSuccess()
    {
        when(bookRepository.findById(anyInt())).thenReturn(Optional.of(book));
        when(bookConverter.entityToDTO(any(Book.class))).thenReturn(bookDTO);
        assertNotNull(bookService.getBook(anyInt()));
    }

    @Test
    void test_getBookError()
    {
        assertThrows(BookNotFoundException.class,()->bookService.getBook(anyInt()));
    }

    @Test
    void test_addBook()
    {
        when(bookConverter.dtoTOEntity(any(BookDTO.class))).thenReturn(book);
        when(bookRepository.save(any(Book.class))).thenReturn(book);
        when(bookConverter.entityToDTO(any(Book.class))).thenReturn(bookDTO);
        assertNotNull(bookService.addBook(bookDTO));
    }

    @Test
    void test_deleteBookSuccess()
    {
        bookRepository.deleteById(anyInt());
        verify(bookRepository).deleteById(anyInt());
        verify(bookRepository,times(1)).deleteById(anyInt());
    }

    @Test
    void test_deleteBookError()
    {

     assertThrows(BookNotFoundException.class,()->bookService.deleteBook(null));
    }

    @Test
    void test_updateBookSuccess()
    {
      when(bookRepository.findById(anyInt())).thenReturn(Optional.of(book));
      when(bookConverter.dtoTOEntity(any(BookDTO.class))).thenReturn(book);
      when(bookRepository.save(any(Book.class))).thenReturn(book);
      when(bookConverter.entityToDTO(any(Book.class))).thenReturn(bookDTO);
      assertNotNull(bookService.updateBook(bookDTO));
    }

    @Test
    void test_updateBookError()
    {
        assertThrows(BookNotFoundException.class,()->bookService.updateBook(bookDTO));
    }
}
