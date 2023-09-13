package org.leetcode.kth_largest_element_in_an_array;

import java.util.Collection;
import java.util.NoSuchElementException;

// AbstractCollection 을 상속받는다.(생략)
public abstract class AbstractQueue<E> implements Queue<E> {
    protected AbstractQueue() {
    }

    public boolean add(E e) {
        if (offer(e)) {
            return true;
        } else {
            throw new IllegalStateException("Queue full");
        }
    }

    public E remove() {
        E x = poll();
        if (x != null) {
            return x;
        } else {
            throw new NoSuchElementException();
        }
    }

    public E element() {
        E x = peek();
        if (x != null) {
            return x;
        } else {
            throw new NoSuchElementException();
        }
    }

    public void clear() {
        while (poll() != null) {
            ;
        }
    }

    public boolean addAll(Collection<? extends E> c) {
        if (c == null) {
            throw new NullPointerException();
        } else if (c == this) {
            throw new IllegalArgumentException();
        } else {
            boolean modified = false;

            for (E e : c) {
                if (add(e)) {
                    modified = true;
                }
            }

            return modified;
        }
    }
}
