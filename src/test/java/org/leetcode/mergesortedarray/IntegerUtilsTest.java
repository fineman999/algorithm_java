package org.leetcode.mergesortedarray;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class IntegerUtilsTest {

    @ParameterizedTest
    @CsvSource({"0", "200"})
    @DisplayName("range 메서드는 0 이상 200 이하의 정수를 받아 true 를 반환한다.")
    void range(int sut) {
        boolean range = IntegerUtils.range(sut);
        assertThat(range).isTrue();
    }

    @ParameterizedTest
    @CsvSource({"-1", "201"})
    @DisplayName("range 메서드는 0 미만 201 초과의 정수를 받아 false 를 반환한다.")
    void rangeFalse(int sut) {
        boolean range = IntegerUtils.range(sut);
        assertThat(range).isFalse();
    }

    @ParameterizedTest
    @CsvSource({"0, 0", "200, 0", "0, 200", "100, 100"})
    @DisplayName("sumRange 메서드는 0 이상 200 이하의 정수를 받아 true 를 반환한다.")
    void sumRange(int m, int n) {
        boolean sumRange = IntegerUtils.sumRange(m, n);
        assertThat(sumRange).isTrue();
    }

    @ParameterizedTest
    @CsvSource({"-1, 0", "201, 0", "0, -1", "0, 201", "100, 101"})
    @DisplayName("sumRange 메서드는 0 미만 201 초과의 정수를 받아 false 를 반환한다.")
    void sumRangeFalse(int m, int n) {
        boolean sumRange = IntegerUtils.sumRange(m, n);
        assertThat(sumRange).isFalse();
    }

    @Test
    @DisplayName("length 메서드는 nums2 배열과 n 를 받아 true 를 반환한다.")
    void length() {
        int[] nums1 = new int[]{1, 2, 3};
        int n = 3;
        boolean length1 = IntegerUtils.length(nums1, n);
        assertThat(length1).isTrue();
    }

    @Test
    @DisplayName("length 메서드는 nums2 배열과 n 를 받아 false 를 반환한다.")
    void lengthFalse() {
        int[] nums1 = new int[]{1, 2, 3};
        int n = 2;
        boolean length1 = IntegerUtils.length(nums1, n);
        assertThat(length1).isFalse();
    }

    @Test
    @DisplayName("length 메서드는 nums1 배열과 m, n 를 받아 true 를 반환한다.")
    void length2() {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int m = 3;
        int n = 3;
        boolean length1 = IntegerUtils.length(nums1, m, n);
        assertThat(length1).isTrue();
    }

    @Test
    @DisplayName("length 메서드는 nums1 배열과 m, n 를 받아 false 를 반환한다.")
    void length2False() {
        int[] nums1 = new int[]{1, 2, 3};
        int m = 2;
        int n = 3;
        boolean length1 = IntegerUtils.length(nums1, m, n);
        assertThat(length1).isFalse();
    }
}