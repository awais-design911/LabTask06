package com.lab6;

/**
 * Lab Task 4 - Library System ADT.
 *
 * Defines WHAT a library system does, independent of HOW it is
 * implemented (array list, hash map, database, etc). Clients depend
 * only on this contract.
 */
public interface LibrarySystem {

    /**
     * Adds a new book to the library catalogue.
     *
     * @param book the book to add
     */
    void addBook(Book book);

    /**
     * Removes a book from the catalogue by its ID.
     *
     * @param bookId the ID of the book to remove
     * @return true if a book was removed, false if no such book existed
     */
    boolean removeBook(String bookId);

    /**
     * Searches for a book by its ID.
     *
     * @param bookId the ID of the book to search for
     * @return the matching Book, or null if not found
     */
    Book searchBook(String bookId);

    /**
     * Issues (borrows out) a book by its ID.
     *
     * @param bookId the ID of the book to issue
     * @return true if the book was successfully issued, false if the
     *         book does not exist or is already issued
     */
    boolean issueBook(String bookId);

    /**
     * Returns a previously issued book by its ID.
     *
     * @param bookId the ID of the book to return
     * @return true if the book was successfully returned, false if the
     *         book does not exist or was not issued
     */
    boolean returnBook(String bookId);
}
