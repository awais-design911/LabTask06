package com.lab6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentTest {

    // Note: direct field access such as `new Student(1,"Ali",3.5).id`
    // is intentionally impossible to write here - the fields are
    // private, so any such line would fail to compile. Access must go
    // through the public getters, which this test exercises.

    @Test
    void gettersReturnConstructorValues() {
        Student student = new Student(101, "Ali Raza", 3.75);

        assertEquals(101, student.getId());
        assertEquals("Ali Raza", student.getName());
        assertEquals(3.75, student.getCgpa(), 0.0001);
    }

    @Test
    void toStringContainsKeyFields() {
        Student student = new Student(7, "Sara Khan", 3.9);
        String text = student.toString();

        assertEquals(true, text.contains("Sara Khan"));
        assertEquals(true, text.contains("7"));
    }
}
