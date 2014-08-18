package net.n39i.dsaa;

import java.util.NoSuchElementException;
import java.util.Optional;

/** @since 1.8 */
public class MyLinkedList<E> {

    private Optional<Entry<E>> first = Optional.empty();

    public int size() {
        if (!first.isPresent()) {
            return 0;
        } else {
            int cnt = 1;
            Entry<E> entry = first.get();
            for (;;) {
                if (entry.next.isPresent()) {
                    cnt++;
                    entry = entry.next.get();
                } else {
                    return cnt;
                }
            }
        }
    }

    public void add(E e) {
        Optional<Entry<E>> entry = Optional.of(new Entry<>(e));
        if (first.isPresent()) {
            first.get().getLast().next = entry;
        } else {
            first = entry;
        }
    }

    public E get(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException(String.valueOf(index));
        }
        try {
            Entry<E> entry = first.get();
            for (int cnt = 0; cnt < index; cnt++) {
                entry = entry.next.get();
            }
            return entry.value;
        } catch (NoSuchElementException e) {
            throw new IndexOutOfBoundsException(String.valueOf(index));
        }
    }

    private static class Entry<E> {

        final E value;

        Optional<Entry<E>> next = Optional.empty();

        Entry(E e) {
            this.value = e;
        }

        private Entry<E> getLast() {
            return next.isPresent()
                    ? next.get().getLast()
                    : this;
        }

    }

}
