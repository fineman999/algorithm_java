package org.leetcode.longest_substring_without_reapeating_characters;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {

    private final Map<Character, Integer> storage = new LinkedHashMap<>();
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int max = 0;
        storage.clear();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (storage.containsKey(c)) {
                int index = storage.get(c);
                storage.entrySet().removeIf(entry -> entry.getValue() <= index);
            }
            storage.put(c, i);
            max = Math.max(max, storage.size());
        }
        return max;
    }
}
