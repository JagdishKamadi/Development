package com.epam.service;

import com.epam.dto.LibraryDTO;

public interface LibraryService {

    LibraryDTO issueBook(LibraryDTO libraryDTO);

    String releaseBook(LibraryDTO libraryDTO);
}
