package com.lab6;

import java.util.ArrayList;
import java.util.List;

/**
 * Lab Task 5 - Concrete implementation of {@link StudentCollection}.
 *
 * Backed by an {@link ArrayList}. This is an implementation detail that
 * client code should never depend on directly - only on the
 * {@link StudentCollection} interface.
 */
public class StudentCollectionImpl implements StudentCollection {

    private final List<Student> students;

    public StudentCollectionImpl() {
        this.students = new ArrayList<>();
    }

    @Override
    public void addStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("student must not be null");
        }
        students.add(student);
    }

    @Override
    public boolean removeStudent(int id) {
        return students.removeIf(s -> s.getId() == id);
    }

    @Override
    public Student findStudent(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    @Override
    public int getSize() {
        return students.size();
    }

    @Override
    public boolean isEmpty() {
        return students.isEmpty();
    }
}
