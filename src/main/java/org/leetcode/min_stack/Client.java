package org.leetcode.min_stack;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {

        List<String> inputs = List.of("MinStack", "push(-2)", "push(0)", "push(-3)", "getMin", "pop", "top", "getMin");

        MinStack minStack = null;

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < inputs.size(); i++) {
            String input = inputs.get(i);
            if (input.equals("MinStack")) {
                minStack = new MinStack();
                result.add(null);
            } else if (input.startsWith("push")) {
                int x = Integer.parseInt(input.substring(5, input.length() - 1));
                minStack.push(x);
                result.add(null);
            } else if (input.equals("pop")) {
                minStack.pop();
                result.add(null);
            } else if (input.equals("top")) {
                int temp = minStack.top();
                result.add(temp);
            } else if (input.equals("getMin")) {
                int temp = minStack.getMin();
                result.add(temp);
            }
        }
        System.out.println(result);
    }
}
