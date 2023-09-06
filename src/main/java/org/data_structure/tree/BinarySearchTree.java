package org.data_structure.tree;

import java.util.StringJoiner;

public class BinarySearchTree<T extends Comparable<T>> {
    public Node<T> root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(T data) {
        root = insert(root, data);
    }

    public Node<T> search(T data) {
        return search(root, data);
    }

    public Node<T> delete(T data) {
        return delete(root, data);
    }
    private Node<T> insert(Node<T> node, T data) {
        if (node == null) {
            node = new Node<>(data);
            return node;
        }

        if (data.compareTo(node.data) < 0) {
            node.left = insert(node.left, data);
        } else {
            node.right = insert(node.right, data);
        }
        return node;
    }

    private Node<T> search(Node<T> node, T data) {
        if (node == null) return null;
        if (data.compareTo(node.data) == 0) return node;
        if (data.compareTo(node.data) < 0) return search(node.left, data);
        return search(node.right, data);
    }

    private Node<T> delete(Node<T> node, T data) {
        if (node == null) return null;

        if (data.compareTo(node.data) < 0) {
            node.left = delete(node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            node.right = delete(node.right, data);
        } else {

            if (node.left == null && node.right == null) {
                node = null;
            } else if (node.left == null) {
                node = node.right;
            } else if (node.right == null) {
                node = node.left;
            } else {
                Node<T> temp = findMaxInLeftSubtree(node.right);
                node.data = temp.data;
                node.right = delete(node.right, temp.data);
            }
        }
        return node;
    }

    private Node<T> findMaxInLeftSubtree(Node<T> node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private void inOrder(Node<T> node, StringJoiner joiner) {
        if (node == null) return;
        inOrder(node.left, joiner);
        joiner.add(node.data.toString());
        inOrder(node.right, joiner);
    }

    /**
     * 중위 순회
     */
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        inOrder(root, joiner);
        return joiner.toString();
    }
}
