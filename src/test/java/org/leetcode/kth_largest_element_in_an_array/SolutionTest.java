package org.leetcode.kth_largest_element_in_an_array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    private final Solution solution = new Solution();

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(new int[]{3,2,1,5,6,4}, 2, 5),
                Arguments.of(new int[]{3,2,3,1,2,4,5,5,6}, 4, 4)
        );
    }

    @ParameterizedTest
    @MethodSource("generateData")
    @DisplayName("findKthLargest 메서드는 int[] nums, int k 를 받아 k번째로 큰 수를 반환한다.")
    void findKthLargest(int[] nums, int k, int expected) {

        int kthLargest = solution.findKthLargest(nums, k);

        assertThat(kthLargest).isEqualTo(expected);
    }
}