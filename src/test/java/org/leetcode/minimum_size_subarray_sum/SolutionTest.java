package org.leetcode.minimum_size_subarray_sum;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    @DisplayName("Test case 1")
    void minSubArrayLen() {
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        int expected = 2;
        int actual = new Solution().minSubArrayLen(target, nums);

        assertThat(actual).isEqualTo(expected);
    }

}