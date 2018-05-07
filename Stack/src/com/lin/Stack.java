package com.lin;

/**
 * Created by l on 2018/5/6.
 * O(1)
 */
public interface Stack<E> {

    int getSize();

    boolean isEmpty();

    void push(E e);

    E pop();

    E peek();
}
