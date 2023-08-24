package org.leetcode.mergesortedarray;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


class SolutionTest {

    private final Solution solution = new Solution();

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3, new int[]{1, 2, 2, 3, 5, 6}),
                Arguments.of(new int[]{1}, 1, new int[]{}, 0, new int[]{1}),
                Arguments.of(new int[]{0}, 0, new int[]{1}, 1, new int[]{1})
        );
    }
    @ParameterizedTest
    @MethodSource("generateData")
    @DisplayName("예제 테스트")
    void example1(int nums1[], int m, int nums2[], int n, int expected[]) {
        solution.merge(nums1, m, nums2, n);
        assertThat(nums1).isEqualTo(expected);
    }

}