package org.leetcode.sortlist;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ListNodeTest {

    @Test
    @DisplayName("of(4, 2, 1, 3)을 통해 ListNode 4 -> 2 -> 1 -> 3을 생성할 수 있다.")
    void example() {
        ListNode head = ListNode.of(4, 2, 1, 3);
        assertThat(head.toString()).isEqualTo("4 -> 2 -> 1 -> 3");
    }

    @Test
    @DisplayName("of(-1, 5, 3, 4, 0)을 통해 ListNode -1 -> 5 -> 3 -> 4 -> 0을 생성할 수 있다.")
    void example2() {
        ListNode head = ListNode.of(-1, 5, 3, 4, 0);
        assertThat(head.toString()).isEqualTo("-1 -> 5 -> 3 -> 4 -> 0");
    }
}