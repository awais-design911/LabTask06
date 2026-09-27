package com.lab6;

import java.util.HashMap;
import java.util.Map;

/**
 * Lab Task 4 - Concrete implementation of {@link LibrarySystem}.
 *
 * Uses a {@link HashMap} keyed by book ID for O(1) average-case lookup,
 * issue, and return operations. This class is an implementation detail;
 * client code should depend only on the {@link LibrarySystem} interface.
 */
public class LibraryImplementation implements LibrarySystem {

    private final Map<String, Book> catalogue;

    public LibraryImplementation() {
        this.catalogue = new HashMap<>();
    }

    @Override
    public void addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("book must not be null");
        }
        catalogue.put(book.getBookId(), book);
    }

    @Override
    public boolean removeBook(String bookId) {
        return catalogue.remove(bookId) != null;
    }

    @Override
    public Book searchBook(String bookId) {
        return catalogue.get(bookId);
    }

    @Override
    public boolean issueBook(String bookId) {
        Book book = catalogue.get(bookId);
        if (book == null || book.isIssued()) {
            return false;
        }
        book.setIssued(true);
        return true;
    }

    @Override
    public boolean returnBook(String bookId) {
        Book book = catalogue.get(bookId);
        if (book == null || !book.isIssued()) {
            return false;
        }
        book.setIssued(false);
        return true;
    }
}
