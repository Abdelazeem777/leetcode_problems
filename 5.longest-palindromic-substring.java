/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        final int stringLength = s.length();
        if (stringLength < 2)
            return s;

        String result = String.valueOf(s.charAt(0));
        for (int i = 0; i < stringLength; i++) {
            int start = i - 1 <= 0 ? 0 : i - 1;
            int end = i + 1 >= stringLength - 1 ? stringLength - 1 : i + 1;

            while (start > 0 && s.charAt(start) == s.charAt(i))
                start--;

            while (end < stringLength - 1 && s.charAt(end) == s.charAt(i))
                end++;

            if (s.charAt(start == i ? start : start + 1) == s.charAt(end == i ? end : end - 1))
                result = calcRes(s, result, start == i ? start : start + 1, end == i ? end : end - 1);

            for (int j = 0; j < stringLength; j++) {
                int newStart = 0;
                if (start - j < 0)
                    break;
                else
                    newStart = start - j;

                int newEnd = 0;
                if (end + j > stringLength - 1)
                    break;
                else
                    newEnd = end + j;

                if (s.charAt(newStart) == s.charAt(newEnd))
                    result = calcRes(s, result, newStart, newEnd);
                else
                    break;

            }
        }
        return result;
    }

    private String calcRes(String mainString, String oldResult, int newStart, int newEnd) {
        if (oldResult.length() < newEnd - newStart + 1)
            oldResult = mainString.substring(newStart, newEnd + 1);
        return oldResult;
    }
}
// @lc code=end
