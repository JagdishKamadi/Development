package com.epam.service;

import com.epam.converter.BookConverter;
import com.epam.dto.BookDTO;
import com.epam.exception.BookNotFoundException;
import com.epam.model.Book;
import com.epam.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookConverter bookConverter;

    @Override
    public List<BookDTO> getBooks() {
        List<Book> bookList = bookRepository.findAll();
        return bookList.stream()
                .map(book -> bookConverter.entityToDTO(book))
                .collect(Collectors.toList());
    }

    @Override
    public BookDTO getBook(Integer bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(()-> new  BookNotFoundException("Book not found for id "+bookId));
        return bookConverter.entityToDTO(book);
    }

    @Override
    public BookDTO addBook(BookDTO bookDTO) {
       Book book =  bookRepository.save(bookConverter.dtoTOEntity(bookDTO));
        return bookConverter.entityToDTO(book);
    }

    @Override
    public void deleteBook(Integer bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(()->new BookNotFoundException("Book not found for id "+bookId));
        bookRepository.deleteById(bookId);
    }

    @Override
    public BookDTO updateBook(BookDTO bookDTO) {
        Book book = bookRepository.findById(bookDTO.getBookId()).orElseThrow(()->new BookNotFoundException("Book not found for id "+bookDTO.getBookId()));
        book = bookRepository.save(bookConverter.dtoTOEntity(bookDTO));
        return bookConverter.entityToDTO(book);
    }
}
