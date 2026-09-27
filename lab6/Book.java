package com.lab6;

/**
 * Lab Task 4 - Data element of the Library System ADT.
 *
 * Represents a single book: its ID, title, author, and whether it is
 * currently issued out to a borrower.
 */
public class Book {

    private final String bookId;
    private final String title;
    private final String author;
    private boolean issued;

    public Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.issued = false;
    }

    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isIssued() {
        return issued;
    }

    public void setIssued(boolean issued) {
        this.issued = issued;
    }

    @Override
    public String toString() {
        return "Book{id='" + bookId + "', title='" + title + "', author='" + author
                + "', issued=" + issued + '}';
    }
}
