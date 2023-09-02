package org.leetcode.sortlist;

public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode middle = getMiddle(head);
        ListNode nextOfMiddle = middle.next;
        middle.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(nextOfMiddle);
        return merge(left, right);
    }

    private ListNode getMiddle(ListNode head) {
        if (head == null) return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return slow;
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                tail.next = left;
                left = left.next;
            }
            else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }
        if (left != null) tail.next = left;
        if (right != null) tail.next = right;
        return dummy.next;
    }
}
