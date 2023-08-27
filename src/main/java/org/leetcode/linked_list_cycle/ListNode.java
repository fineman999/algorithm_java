package org.leetcode.linked_list_cycle;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    public static ListNode of(int... values) {
        if (values == null) {
            throw new IllegalArgumentException("values cannot be null");
        }
        ListNode head = new ListNode(values[0]);
        ListNode curr = head;
        for (int i = 1; i < values.length; i++) {
            curr.next = new ListNode(values[i]);
            curr = curr.next;
        }
        return head;
    }

    public static void setPos(ListNode head, int pos) {
        if (pos == -1) {
            return;
        }
        ListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }

        ListNode posNode = head;
        for (int i = 0; i < pos; i++) {
            posNode = posNode.next;
        }
        curr.next = posNode;
    }
}

//    public void add(int value) {
//        ListNode curr = this;
//        while (curr.next != null) {
//            curr = curr.next;
//        }
//        curr.next = new ListNode(value);
//    }
//
//    public void remove(int value) {
//        ListNode curr = this;
//        while (curr.next != null) {
//            if (curr.next.val == value) {
//                curr.next = curr.next.next;
//                return;
//            }
//            curr = curr.next;
//        }
//    }
//
//    public void print() {
//        ListNode curr = this;
//        while (curr != null) {
//            System.out.print(curr.val + " ");
//            curr = curr.next;
//        }
//        System.out.println("");
//    }

