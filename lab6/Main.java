package com.lab6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Demonstrates Lab Tasks 1, 2, and 3 with console output that can be
 * screenshotted for the PDF report.
 */
public class Main {

    public static void main(String[] args) {
        taskOne_StackAdt();
        System.out.println();
        taskTwo_Encapsulation();
        System.out.println();
        taskThree_ProgrammingToAbstraction();
    }

    /** Lab Task 1 - Implementing the Stack ADT. */
    private static void taskOne_StackAdt() {
        System.out.println("=== Lab Task 1: Stack ADT (ArrayStack) ===");
        Stack<Integer> stack = new ArrayStack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Pushed: 10, 20, 30");

        int popped = stack.pop();
        System.out.println("pop() returned: " + popped);
        System.out.println("Expected 30 -> " + (popped == 30 ? "PASS" : "FAIL"));
        System.out.println("Remaining size: " + stack.size());
    }

    /** Lab Task 2 - Data Encapsulation. */
    private static void taskTwo_Encapsulation() {
        System.out.println("=== Lab Task 2: Encapsulation (Student) ===");
        Student student = new Student(1, "Ali Raza", 3.75);

        // Direct field access such as `student.id` or `student.name` is NOT
        // possible here because the fields are private - attempting it
        // would cause a COMPILATION ERROR, e.g.:
        //
        //     student.id = 5;      // compile error: id has private access in Student
        //     System.out.println(student.name); // compile error
        //
        // Access is only possible through the public getters below,
        // which proves encapsulation is working.
        System.out.println("Id: " + student.getId());
        System.out.println("Name: " + student.getName());
        System.out.println("CGPA: " + student.getCgpa());
    }

    /** Lab Task 3 - Programming to an Abstraction. */
    private static void taskThree_ProgrammingToAbstraction() {
        System.out.println("=== Lab Task 3: Programming to an Abstraction ===");

        List<String> students; // depends only on the List interface

        students = new ArrayList<>();
        students.add("Ali");
        System.out.println("Using ArrayList implementation: " + students);

        students = new LinkedList<>(); // same variable, swapped implementation
        students.add("Sara");
        System.out.println("Using LinkedList implementation: " + students);

        System.out.println("Client code (the variable's type and the calls made on it) "
                + "did not change when the implementation changed.");
    }
}
