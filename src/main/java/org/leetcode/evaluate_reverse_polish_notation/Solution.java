package org.leetcode.evaluate_reverse_polish_notation;

import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            calculate(token, stack);
        }
        return stack.pop();
    }

    private void calculate(String token, Stack<Integer> stack) {
        switch (token) {
            case "+" -> {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a + b);
            }
            case "-" -> {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            }
            case "*" -> {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a * b);
            }
            case "/" -> {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            }
            default -> stack.push(Integer.parseInt(token));
        }
    }
}
