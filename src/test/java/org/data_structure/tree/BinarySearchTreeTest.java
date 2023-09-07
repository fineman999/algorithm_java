package org.data_structure.tree;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class BinarySearchTreeTest {


    @Test
    @DisplayName("insert 테스트")
    void insert() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);
        assertThat(bst.toString()).isEqualTo("[20, 30, 40, 50, 60, 70, 80]");
    }

    @Test
    void search() {
        BinarySearchTree<Double> bst = new BinarySearchTree<>();

        bst.insert(50.1);
        bst.insert(30.3);
        bst.insert(70.4);
        bst.insert(20.5);
        bst.insert(40.6);
        bst.insert(60.7);
        bst.insert(80.8);

        assertAll(
                () -> assertThat(bst.search(50.1)).isTrue(),
                () -> assertThat(bst.search(80.8)).isTrue(),
                () -> assertThat(bst.search(100.1)).isFalse()
        );
    }

    @Test
    void delete() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        bst.delete(20);
        assertThat(bst.toString()).isEqualTo("[30, 40, 50, 60, 70, 80]");

        bst.delete(30);
        assertThat(bst.toString()).isEqualTo("[40, 50, 60, 70, 80]");

        bst.delete(50);
        assertThat(bst.toString()).isEqualTo("[40, 60, 70, 80]");

    }
}