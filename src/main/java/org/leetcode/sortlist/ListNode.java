package org.leetcode.sortlist;

import java.util.StringJoiner;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode of(int... values) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        for (int value : values) {
            tail.next = new ListNode(value);
            tail = tail.next;
        }
        return dummy.next;
    }


    /**
     * ListNode를 문자열 표현을 반환한다.
     * 이 문자열은 next를 통해 값 -> 다음 값 -> 다음 값 -> ...  형태로 반환한다.
     * next가 null이면 값만 반환한다.
     */
    @Override
    public String toString() {
        if (next == null) return String.valueOf(val);

        return new StringJoiner(" -> ", "", "")
                .add(String.valueOf(val))
                .add(next.toString())
                .toString();
    }
}
