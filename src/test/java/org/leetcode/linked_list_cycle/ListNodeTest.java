package org.leetcode.linked_list_cycle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ListNodeTest {

    @Test
    @DisplayName("of 메서드는 int[] 를 받아 ListNode 를 생성한다.")
    void of() {
        int[] values = {1, 2, 3, 4, 5};

        ListNode curr = ListNode.of(values);
        for (int value : values) {
            assertThat(value).isEqualTo(curr.val);
            curr = curr.next;
        }
    }

    @Test
    @DisplayName("of 메서드는 int[] 가 null 일 때 IllegalArgumentException 을 던진다.")
    void ofException() {
        int[] values = null;
        assertThatThrownBy(() -> ListNode.of(values))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("setPos 메서드는 ListNode head 와 int pos 를 받아 마지막 노드의 next 를 pos 번째 노드로 설정한다.")
    void setPost() {
        int pos = 1;
        int lastNodeValue = 4;
        ListNode head = ListNode.of(3, 2, 0, -4);
        ListNode.setPos(head, pos);

        ListNode posNode = head;
        for (int i = 0; i < pos; i++) {
            posNode = posNode.next;
        }

        ListNode lastNode = head;
        for (int i = 0; i < lastNodeValue; i++) {
            lastNode = lastNode.next;
        }
        assertThat(posNode).isEqualTo(lastNode);
    }

    @Test
    @DisplayName("setPos 메서드는 ListNode head 와 int pos 가 -1 일 때 cycle을 만들지 않는다.")
    void setPostNot() {
        int pos = -1;
        ListNode head = ListNode.of(3, 2, 0, -4);
        ListNode.setPos(head, pos);

        ListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        assertThat(curr.next).isNull();
    }
}