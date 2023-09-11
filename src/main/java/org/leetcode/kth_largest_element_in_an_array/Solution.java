package org.leetcode.kth_largest_element_in_an_array;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        for (int num : nums) {
            queue.add(num);
        }

        while (k != 1) {
            queue.poll();
            k -= 1;
        }

        return queue.peek();
    }
}
