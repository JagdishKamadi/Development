package com.epam.service;

import com.epam.dto.BookDTO;

import java.util.List;

public interface BookService {
    List<BookDTO> getBooks();
    BookDTO getBook(Integer bookId);
    BookDTO addBook(BookDTO bookDTO);
    void deleteBook(Integer bookId);
    BookDTO updateBook(BookDTO bookDTO);

}
