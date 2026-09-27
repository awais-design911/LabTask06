package com.lab6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentCollectionImplTest {

    private StudentCollection collection;

    @BeforeEach
    void setUp() {
        collection = new StudentCollectionImpl();
    }

    @Test
    void newCollectionIsEmpty() {
        assertTrue(collection.isEmpty());
        assertEquals(0, collection.getSize());
    }

    @Test
    void addStudentIncreasesSize() {
        collection.addStudent(new Student(1, "Ali", 3.5));
        assertFalse(collection.isEmpty());
        assertEquals(1, collection.getSize());
    }

    @Test
    void findStudentReturnsCorrectStudent() {
        collection.addStudent(new Student(1, "Ali", 3.5));
        collection.addStudent(new Student(2, "Sara", 3.9));

        Student found = collection.findStudent(2);
        assertNotNull(found);
        assertEquals("Sara", found.getName());
    }

    @Test
    void findStudentReturnsNullWhenNotFound() {
        collection.addStudent(new Student(1, "Ali", 3.5));
        assertNull(collection.findStudent(999));
    }

    @Test
    void removeStudentDeletesById() {
        collection.addStudent(new Student(1, "Ali", 3.5));
        collection.addStudent(new Student(2, "Sara", 3.9));

        assertTrue(collection.removeStudent(1));
        assertEquals(1, collection.getSize());
        assertNull(collection.findStudent(1));
    }

    @Test
    void removeStudentReturnsFalseWhenIdNotPresent() {
        collection.addStudent(new Student(1, "Ali", 3.5));
        assertFalse(collection.removeStudent(999));
    }
}
