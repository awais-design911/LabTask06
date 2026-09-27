package com.lab6;

import java.util.EmptyStackException;

/**
 * Lab Task 1 - Concrete array-backed implementation of the {@link Stack} ADT.
 *
 * Internally uses a simple resizable array to store elements, following
 * the LIFO (Last In, First Out) principle.
 *
 * @param <T> the type of elements held in this stack
 */
public class ArrayStack<T> implements Stack<T> {

    private static final int DEFAULT_CAPACITY = 10;

    private Object[] elements;
    private int count;

    public ArrayStack() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.count = 0;
    }

    @Override
    public void push(T item) {
        ensureCapacity();
        elements[count++] = item;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T item = (T) elements[count - 1];
        elements[--count] = null; // avoid memory leak
        return item;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return (T) elements[count - 1];
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return count;
    }

    private void ensureCapacity() {
        if (count == elements.length) {
            Object[] newElements = new Object[elements.length * 2];
            System.arraycopy(elements, 0, newElements, 0, elements.length);
            elements = newElements;
        }
    }
}
