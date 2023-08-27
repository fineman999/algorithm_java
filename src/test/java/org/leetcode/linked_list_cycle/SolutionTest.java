package org.leetcode.linked_list_cycle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    private final Solution solution = new Solution();
    @Test
    @DisplayName("hasCycle 메서드는 ListNode인 head [3, 2, 0, -4]를 받고 pos가 1이면 true 를 반환한다.")
    void hasCycle() {
        ListNode head = ListNode.of(3, 2, 0, -4);
        ListNode.setPos(head, 1);

        boolean actual = solution.hasCycle(head);

        assertThat(actual).isTrue();
    }

    @Test
    @DisplayName("hasCycle 메서드는 ListNode인 head [1, 2]를 받아 pos가 0이면 true 를 반환한다.")
    void hasCycle2() {
        ListNode head = ListNode.of(1, 2);
        ListNode.setPos(head, 0);

        boolean actual = solution.hasCycle(head);

        assertThat(actual).isTrue();
    }

    @Test
    @DisplayName("hasCycle 메서드는 ListNode인 head [1]를 받아 pos가 -1이면 false 를 반환한다.")
    void hasCycle3() {
        ListNode head = ListNode.of(1);
        ListNode.setPos(head, -1);

        boolean actual = solution.hasCycle(head);

        assertThat(actual).isFalse();
    }
}