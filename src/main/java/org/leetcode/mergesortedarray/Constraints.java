package org.leetcode.mergesortedarray;

import static org.leetcode.mergesortedarray.IntegerUtils.*;


public final class Constraints implements Subject {
    private final Subject target;

    public Constraints(Subject target) {
        this.target = target;
    }

    @Override
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        check(nums1, m, nums2, n);
        target.merge(nums1, m, nums2, n);
    }

    private void check(int[] nums1, int m, int[] nums2, int n) {
        checkRange(m);
        checkRange(n);
        checkSumLength(m, n);
        checkLength(nums1, m, n);
        checkLength(nums2, n);
    }

    private void checkRange(int number) {
        if (!range(number)) {
            throw new IllegalArgumentException("number is out of range");
        }
    }

    private void checkSumLength(int m, int n) {
        if (!sumRange(m, n)) {
            throw new IllegalArgumentException("nums.length != length");
        }
    }

    private void checkLength(int[] nums, int length) {
        if (!length(nums, length)) {
            throw new IllegalArgumentException("nums.length != length");
        }
    }

    private void checkLength(int[] nums, int m, int n) {
        if (!length(nums, m, n)) {
            throw new IllegalArgumentException("nums.length != length");
        }
    }
}
