package org.leetcode.evaluate_reverse_polish_notation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(new String[]{"2", "1", "+", "3", "*"}, 9),
                Arguments.of(new String[]{"4", "13", "5", "/", "+"}, 6),
                Arguments.of(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}, 22)

        );
    }
    @ParameterizedTest
    @MethodSource("generateData")
    @DisplayName("evalRPN 메서드는 String[] tokens 를 받아 계산 결과를 반환한다.")
    void example(String[] tokens, int expected) {

        Solution solution = new Solution();
        int actual = solution.evalRPN(tokens);

        assertThat(expected).isEqualTo(actual);
    }
}