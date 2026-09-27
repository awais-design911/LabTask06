package com.lab6;

/**
 * Lab Task 1 - Stack ADT.
 *
 * Defines the abstract contract of a Stack (LIFO - Last In, First Out).
 * Clients program against this interface, not against a concrete
 * implementation such as {@link ArrayStack}.
 *
 * @param <T> the type of elements held in this stack
 */
public interface Stack<T> {

    /**
     * Pushes an item onto the top of the stack.
     *
     * @param item the item to push; must not be null
     */
    void push(T item);

    /**
     * Removes and returns the item at the top of the stack.
     *
     * @return the item that was on top of the stack
     * @throws java.util.EmptyStackException if the stack is empty
     */
    T pop();

    /**
     * Returns, without removing, the item at the top of the stack.
     *
     * @return the item currently on top of the stack
     * @throws java.util.EmptyStackException if the stack is empty
     */
    T peek();

    /**
     * @return true if the stack contains no elements, false otherwise
     */
    boolean isEmpty();

    /**
     * @return the number of elements currently in the stack
     */
    int size();
}
