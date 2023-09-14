package org.leetcode.snakes_and_ladders;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    private final Solution solution = new Solution();
    @Test
    @DisplayName("Test 1")
    void snakesAndLadders() {
        int[][] board = new int[][]{
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1,  13, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 15, -1, -1, -1, -1}
        };

        int result = solution.snakesAndLadders(board);

        assertThat(result).isEqualTo(4);
    }

    @Test
    @DisplayName("Test 2")
    void snakesAndLadders2() {
        int[][] board = new int[][]{
                {-1, -1},
                {-1, 3}
        };

        int result = solution.snakesAndLadders(board);

        assertThat(result).isEqualTo(1);
    }
}