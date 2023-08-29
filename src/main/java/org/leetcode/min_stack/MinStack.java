package org.leetcode.min_stack;

public class MinStack {
    private Node now;

    public MinStack() {
    }

    public void push(int x) {
        if (now == null) {
            now = new Node(x, x, null);
        } else {
            now = new Node(x, Math.min(x, now.min), now);
        }

    }

    public void pop() {
        now = now.subNode;
    }

    public int top() {
        return now.val;
    }

    public int getMin() {
        return now.min;
    }

    private static class Node {
        int val;
        int min;
        Node subNode;

        public Node(int val, int min, Node subNode) {
            this.val = val;
            this.min = min;
            this.subNode = subNode;
        }
    }
}
