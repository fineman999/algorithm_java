package org.leetcode.search_a_2d_matrix;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    @DisplayName("searchMatrix 메서드는 int[][] matrix 와 int target 을 받아 target 이 존재하면 true 를 반환한다.")
    void searchMatrix() {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34 ,60}};
        int target = 3;

        boolean actual = new Solution().searchMatrix(matrix, target);

        assertThat(actual).isTrue();
    }

    @Test
    @DisplayName("searchMatrix 메서드는 int[][] matrix 와 int target 을 받아 target 이 존재하지 않으면 false 를 반환한다.")
    void searchMatrix2() {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34 ,60}};
        int target = 13;

        boolean actual = new Solution().searchMatrix(matrix, target);

        assertThat(actual).isFalse();
    }
}