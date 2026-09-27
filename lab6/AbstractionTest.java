package com.lab6;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Lab Task 3 - Programming to an Abstraction.
 *
 * Proves that the same client variable, typed only as the List
 * interface, behaves identically no matter which concrete
 * implementation (ArrayList or LinkedList) backs it.
 */
class AbstractionTest {

    @Test
    void listVariableWorksWithArrayListImplementation() {
        List<String> students = new ArrayList<>();
        students.add("Ali");

        assertTrue(students.contains("Ali"));
        assertEquals(1, students.size());
    }

    @Test
    void sameVariableWorksWithLinkedListImplementation() {
        List<String> students;

        students = new ArrayList<>();
        students.add("Ali");

        // Reassign the exact same variable to a different implementation.
        students = new LinkedList<>();
        students.add("Sara");

        assertTrue(students.contains("Sara"));
        assertEquals(1, students.size());
    }
}
