package org.data_structure.tree;

import java.util.Objects;
import java.util.StringJoiner;

public class BinarySearchTree<T extends Comparable<T>> {
    public Node<T> root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(T data) {
        root = insert(root, data);
    }

    public boolean search(T data) {
        return search(root, data);
    }

    public Node<T> delete(T data) {
        return delete(root, data);
    }
    private Node<T> insert(Node<T> node, T data) {
        if (Objects.isNull(node)) {
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

    private boolean search(Node<T> node, T data) {
        if (Objects.isNull(node)) return false;
        if (data.compareTo(node.data) > 0) return search(node.right, data);
        if (data.compareTo(node.data) < 0) return search(node.left, data);
        return true;
    }

    private Node<T> delete(Node<T> node, T data) {
        if (Objects.isNull(node)) return null;

        if (data.compareTo(node.data) < 0) {
            node.left = delete(node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            node.right = delete(node.right, data);
        } else {

            if (Objects.isNull(node.left) && Objects.isNull(node.right)) {
                node = null;
            } else if (Objects.isNull(node.left)) {
                node = node.right;
            } else if (Objects.isNull(node.right)) {
                node = node.left;
            } else {
                Node<T> temp = findMaxInLeftSubtree(node.left);
                node.data = temp.data;
                node.left = delete(node.left, temp.data);
            }
        }
        return node;
    }

    private Node<T> findMaxInLeftSubtree(Node<T> node) {
        if (!Objects.isNull(node.right)) {
            return findMaxInLeftSubtree(node.right);
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
