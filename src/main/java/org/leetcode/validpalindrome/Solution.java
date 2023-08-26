package org.leetcode.validpalindrome;

public final class Solution {

    /**
     * 이 클래스는 인스턴스를 만들 수 없습니다.
     */
    private Solution() {
        throw new AssertionError();
    }

    public static boolean isPalindrome(String s) {
        checkNull(s);

        if (s.isEmpty()) {
            return true;
        }
        int start = 0;
        int last = s.length() - 1;

        while(start <= last) {
            char currFirst = s.charAt(start);
            char currLast = s.charAt(last);
            if (!Character.isLetterOrDigit(currFirst)) {
                start++;
                continue;
            }
            if(!Character.isLetterOrDigit(currLast)) {
                last--;
                continue;
            }

            if (Character.toLowerCase(currFirst) != Character.toLowerCase(currLast)) {
                return false;
            }
            start++;
            last--;
        }
        return true;
    }

    private static void checkNull(String s) {
        if (s == null) {
            throw new IllegalArgumentException("s cannot be null");
        }
    }
}
