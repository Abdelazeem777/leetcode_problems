/*
 * @lc app=leetcode id=14 lang=java
 *
 * [14] Longest Common Prefix
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";

        String result = "";

        for (int i = 0; i < strs[0].length(); i++) {
            final String firstStringPrefix = strs[0].substring(0, i + 1);
            boolean isValid = true;
            for (int j = 1; j < strs.length; j++) {
                final String currentString = strs[j];
                if (currentString == null || currentString.length() < i + 1) {
                    isValid = false;
                    break;
                }
                final String currentStringPrefix = currentString.substring(0, i + 1);
                isValid = firstStringPrefix.equals(currentStringPrefix);
                if (!isValid)
                    break;
            }
            if (!isValid)
                break;

            result = firstStringPrefix;

        }

        return result;

    }
}
// @lc code=end
