package org.leetcode.sortlist;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ListNodeTest {

    private final Solution solution = new Solution();
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

    @Test
    @DisplayName("Solution의 sortList(ListNode head)를 통해 ListNode 4 -> 2 -> 1 -> 3을 정렬할 수 있다.")
    void sorted() {
        ListNode head = ListNode.of(4, 2, 1, 3);
        ListNode newHead = solution.sortList(head);
        assertThat(newHead.toString()).isEqualTo("1 -> 2 -> 3 -> 4");
    }

    @Test
    @DisplayName("Solution의 sortList(ListNode head)를 통해 ListNode -1 -> 5 -> 3 -> 4 -> 0을 정렬할 수 있다.")
    void sorted2() {
        ListNode head = ListNode.of(-1, 5, 3, 4, 0);
        ListNode newHead = solution.sortList(head);
        assertThat(newHead.toString()).isEqualTo("-1 -> 0 -> 3 -> 4 -> 5");
    }
}