package org.leetcode.longest_substring_without_reapeating_characters;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {

    /**
     * 이 클래스는 인스턴스를 만들 수 없습니다.
     */
    private Solution() {
        throw new AssertionError();
    }

    public static int lengthOfLongestSubstring(String s) {
        checkNull(s);
         Map<Character, Integer> storage = new HashMap<>();
        if (s.isEmpty()) {
            return 0;
        }

        int max = 0;
        int left = 0;
        int right = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            if (storage.containsKey(c)) {
                left = Math.max(left, storage.get(c) + 1);
            }
            storage.put(c, right);
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
    private static void checkNull(String s) {
        if (s == null) {
            throw new IllegalArgumentException("s must not be null");
        }
    }
}
