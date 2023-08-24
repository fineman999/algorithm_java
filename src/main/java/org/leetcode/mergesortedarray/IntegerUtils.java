package org.leetcode.mergesortedarray;

public final class IntegerUtils {
    private IntegerUtils() {
    }
    public static boolean range(int length) {
        return length >= 0 && length <= 200;
    }

    public static boolean sumRange(int m, int n) {
        return m + n >= 0 && m + n <= 200;
    }

    public static boolean length(int[] nums1, int m, int n) {
        return nums1.length == m + n;
    }

    public static boolean length(int[] nums2, int n) {
        return nums2.length == n;
    }
}
