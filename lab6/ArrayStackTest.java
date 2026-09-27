package com.lab6;

import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class ArrayStackTest {

    @Test
    void pushThenPopReturnsLifoOrder() {
        Stack<Integer> stack = new ArrayStack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        assertEquals(30, stack.pop(), "pop() should return the most recently pushed item");
    }

    @Test
    void sizeReflectsNumberOfElements() {
        Stack<Integer> stack = new ArrayStack<>();
        assertEquals(0, stack.size());

        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.size());

        stack.pop();
        assertEquals(1, stack.size());
    }

    @Test
    void isEmptyOnNewStack() {
        Stack<String> stack = new ArrayStack<>();
        assertTrue(stack.isEmpty());

        stack.push("a");
        assertFalse(stack.isEmpty());
    }

    @Test
    void peekDoesNotRemoveTopElement() {
        Stack<Integer> stack = new ArrayStack<>();
        stack.push(5);
        stack.push(15);

        assertEquals(15, stack.peek());
        assertEquals(2, stack.size(), "peek() must not remove the element");
    }

    @Test
    void popOnEmptyStackThrows() {
        Stack<Integer> stack = new ArrayStack<>();
        assertThrows(EmptyStackException.class, stack::pop);
    }

    @Test
    void peekOnEmptyStackThrows() {
        Stack<Integer> stack = new ArrayStack<>();
        assertThrows(EmptyStackException.class, stack::peek);
    }

    @Test
    void stackGrowsBeyondDefaultCapacity() {
        Stack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < 50; i++) {
            stack.push(i);
        }
        assertEquals(50, stack.size());
        assertEquals(49, stack.pop());
    }
}
