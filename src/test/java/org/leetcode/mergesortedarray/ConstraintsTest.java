package org.leetcode.mergesortedarray;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ConstraintsTest {

    Subject solution = new Solution();
    Subject constraints = new Constraints(solution);

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3, new int[]{1, 2, 2, 3, 5, 6}),
                Arguments.of(new int[]{1}, 1, new int[]{}, 0, new int[]{1}),
                Arguments.of(new int[]{0}, 0, new int[]{1}, 1, new int[]{1})
        );
    }
    @ParameterizedTest
    @MethodSource("generateData")
    @DisplayName("merge 메서드는 nums1 배열과 m, nums2 배열과 n 을 받아 true 를 반환한다.")
    void merge(int nums1[], int m, int nums2[], int n, int expected[]) {

        constraints.merge(nums1, m, nums2, n);
        assertThat(nums1).isEqualTo(expected);
    }
}