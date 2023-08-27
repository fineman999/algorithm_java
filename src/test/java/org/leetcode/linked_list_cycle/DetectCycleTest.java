package org.leetcode.linked_list_cycle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DetectCycleTest {

    private final Solution solution = new Solution();

    @Test
    @DisplayName("detectCycle 메서드는 ListNode인 head [3, 2, 0, -4]를 받고 pos가 1이면 ListNode [2]를 반환한다.")
    void detectCycle() {
        ListNode head = ListNode.of(3, 2, 0, -4);
        ListNode.setPos(head, 1);

        ListNode actual = solution.detectCycle(head);

        assertThat(actual.val).isEqualTo(2);
    }

    @Test
    @DisplayName("detectCycle 메서드는 ListNode인 head [1, 2]를 받아 pos가 -1이면 null 를 반환한다.")
    void detectCycleNull() {
        ListNode head = ListNode.of(1, 2);
        ListNode.setPos(head, -1);

        ListNode actual = solution.detectCycle(head);

        assertThat(actual).isNull();
    }

    @Test
    @DisplayName("getCycleLength 메서드는 ListNode인 head [3, 2, 0, -4]를 받고 pos가 1이면 3를 반환한다.")
    void getCycleLength() {
        ListNode head = ListNode.of(3, 2, 0, -4);
        ListNode.setPos(head, 1);

        int cycleLength = solution.getCycleLength(head);

        assertThat(cycleLength).isEqualTo(3);
    }

}