package com.epam.service;

import com.epam.converter.LibraryConverter;
import com.epam.dto.LibraryDTO;
import com.epam.exception.AssociationNotFoundException;
import com.epam.model.Library;
import com.epam.repository.LibraryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LibraryServiceTest {

    @Mock
    private LibraryRepository libraryRepository;

    @InjectMocks
    private LibraryServiceImpl libraryServiceImpl;

    @Mock
    private LibraryConverter libraryConverter;

    private Library library;
    private LibraryDTO libraryDTO;

    @BeforeEach
    void setUpObject()
    {
        libraryDTO = new LibraryDTO();
        libraryDTO.setLibraryId(1);
        libraryDTO.setUsername("Jagdish");
        libraryDTO.setBookId(1);

        library = new Library();
        library.setLibraryId(1);
        library.setUsername("Jagdish");
        library.setBookId(1);
    }

    @Test
    void test_addSuccess()
    {
        when(libraryConverter.dtoTOEntity(any(LibraryDTO.class))).thenReturn(library);
        when(libraryRepository.save(any(Library.class))).thenReturn(library);
        when(libraryConverter.entityToDTO(any(Library.class))).thenReturn(libraryDTO);
        assertNotNull(libraryServiceImpl.issueBook(libraryDTO));
    }


    @Test
    void test_deleteSuccess()
    {
       when(libraryRepository.deleteByUsernameAndBookId(anyString(),anyInt())).thenReturn(1);
       assertEquals("Association deleted successfully",libraryServiceImpl.releaseBook(libraryDTO));
    }

    @Test
    void test_deleteError()
    {
        when(libraryRepository.deleteByUsernameAndBookId(anyString(),anyInt())).thenReturn(0);
        assertThrows(AssociationNotFoundException.class,()->libraryServiceImpl.releaseBook(libraryDTO));
    }
}
