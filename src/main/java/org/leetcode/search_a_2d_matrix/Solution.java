package org.leetcode.search_a_2d_matrix;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        checkNull(matrix);
        if (matrix.length == 0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;

        int left = 0;
        int right = row * col - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int midValue = matrix[mid / col][mid % col];

            if (midValue < target) {
                left = mid + 1;
                continue;
            }
            if (midValue > target){
                right = mid - 1;
                continue;
            }
            return true;
        }
        return false;
    }

    private void checkNull(int[][] matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException("matrix must not be null");
        }
    }
}
