package com.lab6;

/**
 * Lab Task 5 - Student Management System ADT.
 *
 * Specifies the operations available on a collection of Students,
 * separately from any particular implementation.
 */
public interface StudentCollection {

    /**
     * Adds a student to the collection.
     *
     * @param student the student to add; must not be null
     */
    void addStudent(Student student);

    /**
     * Removes the student with the given ID.
     *
     * @param id the ID of the student to remove
     * @return true if a student was removed, false if no such student existed
     */
    boolean removeStudent(int id);

    /**
     * Finds the student with the given ID.
     *
     * @param id the ID to search for
     * @return the matching Student, or null if not found
     */
    Student findStudent(int id);

    /**
     * @return the number of students currently in the collection
     */
    int getSize();

    /**
     * @return true if the collection contains no students, false otherwise
     */
    boolean isEmpty();
}
