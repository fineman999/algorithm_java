package org.data_structure.tree;

public class Node<T extends Comparable<T>> implements Comparable<Node<T>>{
    public T data;
    public Node<T> left;
    public Node<T> right;

    public Node(T data) {
        this.data = data;
        this.left = this.right = null;
    }

    @Override
    public int compareTo(Node<T> o) {
        return this.data.compareTo(o.data);
    }
}
