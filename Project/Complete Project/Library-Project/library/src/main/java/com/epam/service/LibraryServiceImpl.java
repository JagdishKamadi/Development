package com.epam.service;

import com.epam.converter.LibraryConverter;
import com.epam.dto.LibraryDTO;
import com.epam.exception.AssociationNotFoundException;
import com.epam.exception.UniqueDetailsException;
import com.epam.model.Library;
import com.epam.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private LibraryRepository libraryRepository;

    @Autowired
    private LibraryConverter libraryConverter;

    @Override
    public LibraryDTO issueBook(LibraryDTO libraryDTO) {
        Library library;
        try{
            library = libraryRepository.save(libraryConverter.dtoTOEntity(libraryDTO));
        }catch(Exception e)
        {
            throw  new UniqueDetailsException("Book with id "+libraryDTO.getBookId()+" is already issued");
        }

        return libraryConverter.entityToDTO(library);
    }

    @Transactional
    public String releaseBook(LibraryDTO libraryDTO) {

        int count = libraryRepository.deleteByUsernameAndBookId(libraryDTO.getUsername(), libraryDTO.getBookId());
        if (count == 0) {
            throw new AssociationNotFoundException();
        }
        return "Association deleted successfully";
    }
}
