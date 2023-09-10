package org.data_structure.list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest {

    @Test
    void add() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();

        linkedList.add(1);
        linkedList.add(2);

        System.out.println(linkedList);

    }

    @Test
    void remove() {
    }
}