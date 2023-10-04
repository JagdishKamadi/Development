package com.epam.converter;

import com.epam.dto.BookDTO;
import com.epam.model.Book;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class BookConverter {
    ModelMapper mapper;
    public BookDTO entityToDTO(Book book)
    {
        mapper = new ModelMapper();
        return  mapper.map(book, BookDTO.class);
    }

    public Book dtoTOEntity(BookDTO bookDTO)
    {
        mapper = new ModelMapper();
        return mapper.map(bookDTO,Book.class);
    }
}
