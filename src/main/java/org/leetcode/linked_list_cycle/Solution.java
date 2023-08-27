package org.leetcode.linked_list_cycle;

public class Solution {
    public boolean hasCycle(ListNode head) {

        if (head == null) {
            return false;
        }

        ListNode tortoise = head;
        ListNode hare = head;

        while (hare != null) {
            if (hare.next == null) {
                return false;
            }
            tortoise = tortoise.next;
            hare = hare.next.next;
            if (tortoise == hare) {
                return true;
            }
        }
        return false;
    }

    public ListNode detectCycle(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode tortoise = head;
        ListNode hare = head;

        while (hare != null) {
            if (hare.next == null) {
                return null;
            }
            tortoise = tortoise.next;
            hare = hare.next.next;
            if (tortoise == hare) {
                return getNode(head, tortoise);
            }
        }
        return null;
    }

    private ListNode getNode(ListNode head, ListNode tortoise) {
        ListNode hare;
        hare = head;
        while (tortoise != hare) {
            tortoise = tortoise.next;
            hare = hare.next;
        }
        return hare;
    }
}
