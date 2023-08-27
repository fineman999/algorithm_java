package org.leetcode.search_a_2d_matrix;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        checkNull(matrix);

        return false;
    }

    private void checkNull(int[][] matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException("matrix must not be null");
        }
    }
}
