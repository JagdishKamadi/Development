package org.example.task2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LibraryTest {

    private Library library;

    @BeforeEach
    void setUp() {
        library = new Library();
    }

    @Test
    void testAddBook() {
        // Given
        String bookTitle = "Book1";

        // When
        library.addBook(bookTitle);

        // Then
        assertTrue(library.hasBook(bookTitle));
    }

    @Test
    void testRemoveBook() {
        // Given
        String bookTitle = "Book1";
        library.addBook(bookTitle);
        assertTrue(library.hasBook(bookTitle));

        // When
        library.removeBook(bookTitle);

        // Then
        assertFalse(library.hasBook(bookTitle));
    }

    @Test
    void testHasBook() {
        // Given
        String bookTitle = "Book1";

        // Then
        assertFalse(library.hasBook(bookTitle));

        // When
        library.addBook(bookTitle);

        // Then
        assertTrue(library.hasBook(bookTitle));
    }

    @Test
    void testAddMultipleBooks() {
        // Given
        String book1 = "Book1";
        String book2 = "Book2";

        // When
        library.addBook(book1);
        library.addBook(book2);

        // Then
        assertTrue(library.hasBook(book1));
        assertTrue(library.hasBook(book2));
    }

    @Test
    void testRemoveNonexistentBook() {
        // Given
        String existingBook = "Book1";
        String nonexistentBook = "NonexistentBook";
        library.addBook(existingBook);
        assertTrue(library.hasBook(existingBook));

        // When
        library.removeBook(nonexistentBook);

        // Then
        assertTrue(library.hasBook(existingBook));
    }
}
