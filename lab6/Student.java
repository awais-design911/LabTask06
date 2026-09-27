package com.lab6;

/**
 * Lab Task 2 - Data Encapsulation.
 *
 * All fields are private so the internal representation of a Student
 * cannot be accessed or modified directly from outside the class.
 * Access is only possible through the public getter methods, which
 * protects the object's invariants.
 */
public class Student {

    private final int id;
    private final String name;
    private final double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', cgpa=" + cgpa + '}';
    }
}
