package com.lab6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryImplementationTest {

    private LibrarySystem library;

    @BeforeEach
    void setUp() {
        library = new LibraryImplementation();
        library.addBook(new Book("B001", "Clean Code", "Robert C. Martin"));
        library.addBook(new Book("B002", "The Pragmatic Programmer", "David Thomas"));
    }

    @Test
    void addBookMakesItSearchable() {
        Book found = library.searchBook("B001");
        assertNotNull(found);
        assertEquals("Clean Code", found.getTitle());
    }

    @Test
    void searchBookReturnsNullWhenNotFound() {
        assertNull(library.searchBook("MISSING"));
    }

    @Test
    void removeBookDeletesFromCatalogue() {
        assertTrue(library.removeBook("B001"));
        assertNull(library.searchBook("B001"));
    }

    @Test
    void removeBookReturnsFalseWhenBookDoesNotExist() {
        assertFalse(library.removeBook("MISSING"));
    }

    @Test
    void issueBookMarksItAsIssued() {
        assertTrue(library.issueBook("B001"));
        assertTrue(library.searchBook("B001").isIssued());
    }

    @Test
    void issueBookFailsIfAlreadyIssued() {
        library.issueBook("B001");
        assertFalse(library.issueBook("B001"), "should not be able to issue an already-issued book");
    }

    @Test
    void returnBookMarksItAsAvailableAgain() {
        library.issueBook("B002");
        assertTrue(library.returnBook("B002"));
        assertFalse(library.searchBook("B002").isIssued());
    }

    @Test
    void returnBookFailsIfNotCurrentlyIssued() {
        assertFalse(library.returnBook("B002"), "cannot return a book that was never issued");
    }
}
