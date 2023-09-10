package org.data_structure.list;

public class SinglyLinkedList<E> {
    private Node<E> head;
    private int size;

    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void add(E data) {
        add(size, data);
    }

    public void add(int index, E data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            addFirst(data);
        } else {
            Node<E> prev = getNode(index - 1);
            addAfter(prev, data);
        }
    }

    public void addFirst(E data) {
        head = new Node<>(data, head);
        size++;
    }

    public void addAfter(Node<E> prev, E data) {
        prev.next = new Node<>(data, prev.next);
        size++;
    }

    public Node<E> getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node;
    }


    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            return removeFirst();
        }

        Node<E> prev = getNode(index - 1);
        return removeAfter(prev);
    }

    public E removeFirst() {
        if (head == null) {
            throw new IndexOutOfBoundsException();
        }

        E data = head.data;
        head = head.next;
        size--;

        return data;
    }

    public E removeAfter(Node<E> prev) {
        if (prev.next == null) {
            throw new IndexOutOfBoundsException();
        }

        E data = prev.next.data;
        prev.next = prev.next.next;
        size--;

        return data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<E> node = head;
        for (int i = 0; i < size; i++) {
            sb.append(node.data);
            if (i < size - 1) {
                sb.append(", ");
            }
            node = node.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
