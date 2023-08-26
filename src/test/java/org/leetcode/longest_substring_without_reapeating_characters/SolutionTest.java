package org.leetcode.longest_substring_without_reapeating_characters;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SolutionTest {


    @ParameterizedTest
    @CsvSource({"abcabcbb, 3", "bbbbb, 1", "pwwkew, 3", "dvdf, 3", "abba, 2"})
    @DisplayName("lengthOfLongestSubstring 메서드는 문자열 s 를 받아 최대 부분 문자열의 길이를 반환한다.")
    void test(String s, int expected) {

        int actual = Solution.lengthOfLongestSubstring(s);

        assertThat(expected).isEqualTo(actual);
    }

    @Test
    @DisplayName("lengthOfLongestSubstring 메서드는 문자열 s 가 null 일 때 IllegalArgumentException 을 던진다.")
    void test2() {
        String s = null;

        assertThatThrownBy(() -> Solution.lengthOfLongestSubstring(s))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("s must not be null");
    }
}