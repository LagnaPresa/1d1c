package net.n39i.dsaa;

import java.util.NoSuchElementException;

public class Stack<T> {

    Item<T> peek;

    private static class Item<T> {

        final T value;

        final Item<T> next;

        Item(T value, Item<T> next) {
            this.value = value;
            this.next = next;
        }

    }

    public void push(T t) {
        peek = new Item<>(t, peek);
    }

    public T pop() {
        if (peek == null) {
            throw new NoSuchElementException();
        }
        T result = peek.value;
        peek = peek.next;
        return result;

    }

}
