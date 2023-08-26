package org.leetcode.validpalindrome;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SolutionTest {
    static Stream<Arguments> generateTrue() {
        return Stream.of(
                Arguments.of("A man, a plan, a canal: Panama"),
                Arguments.of(" ")
        );
    }
    @ParameterizedTest
    @MethodSource("generateTrue")
    @DisplayName("isPalindrome 메서드는 문자열을 받아 Palindrome 일 경우에는 true 를 반환한다.")
    void example(String value) {
        boolean palindrome = Solution.isPalindrome(value);
        assertThat(palindrome).isTrue();
    }

    @Test
    @DisplayName("isPalindrome 메서드는 문자열을 받아 Palindrome 이 아닐 경우에는 false 를 반환한다.")
    void exampleFalse() {
        String s = "race a car";
        boolean palindrome = Solution.isPalindrome(s);
        assertThat(palindrome).isFalse();
    }

    @Test
    @DisplayName("isPalindrome 메서드는 null 을 받을 경우에는 IllegalArgumentException 을 발생시킨다.")
    void exampleNull() {
        String s = null;
        assertThatThrownBy(() -> Solution.isPalindrome(s))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("s cannot be null");
    }
}