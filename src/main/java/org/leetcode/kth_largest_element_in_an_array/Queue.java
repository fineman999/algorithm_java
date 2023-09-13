package org.leetcode.kth_largest_element_in_an_array;

public interface Queue<E> {
    boolean offer(E e);
    E poll();
    E peek();
    int size();
    boolean isEmpty();
}
