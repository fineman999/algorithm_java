package org.leetcode.mergesortedarray;

public class ProxyPattern {
   private final Subject solution;

    public ProxyPattern(Subject solution) {
        this.solution = solution;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        solution.merge(nums1, m, nums2, n);
    }
}
