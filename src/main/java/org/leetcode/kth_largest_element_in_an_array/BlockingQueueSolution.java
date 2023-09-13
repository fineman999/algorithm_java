package org.leetcode.kth_largest_element_in_an_array;

import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;

public class BlockingQueueSolution implements Solution {

    @Override
    public int findKthLargest(int[] nums, int k) {

        PriorityBlockingQueue<Integer> blockingQueue = new PriorityBlockingQueue<>(nums.length, Comparator.reverseOrder());

        for (int num : nums) {
            blockingQueue.put(num);
        }

        while (k != 1 && !blockingQueue.isEmpty()) {
            try {
                blockingQueue.take();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            k -= 1;
        }

        if (blockingQueue.isEmpty()) {
            return -1;
        }

        return blockingQueue.peek();
    }
}
