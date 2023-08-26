package org.leetcode.validpalindrome;

import java.util.StringJoiner;

public class Solution {
    private final StringBuilder sb = new StringBuilder();


    public boolean isPalindrome(String s) {
        String convertedString = convert(s);
        int length = convertedString.length();
        int left = 0;
        int right = length - 1;

        while (left < right) {
            if (convertedString.charAt(left++) != convertedString.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    private String convert(String s) {
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }
        return sb.toString();
    }
}
