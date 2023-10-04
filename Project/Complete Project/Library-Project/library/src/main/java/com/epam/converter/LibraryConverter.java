package com.epam.converter;

import com.epam.dto.LibraryDTO;
import com.epam.model.Library;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class LibraryConverter {

    ModelMapper mapper;
    public LibraryDTO entityToDTO(Library library)
    {
        mapper = new ModelMapper();
        return  mapper.map(library, LibraryDTO.class);
    }

    public Library dtoTOEntity(LibraryDTO libraryDTO)
    {
        mapper = new ModelMapper();
        return mapper.map(libraryDTO,Library.class);
    }
}
