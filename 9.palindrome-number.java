/*
 * @lc app=leetcode id=9 lang=java
 *
 * [9] Palindrome Number
 */

// @lc code=start
class Solution {

    public static boolean isPalindrome(int x) {
        final String s = String.valueOf(x);
        final String[] sArray = s.split("");
        boolean result = true;
        for (int i = 0; i < sArray.length / 2; i++) {
            if (!sArray[i].equals(sArray[sArray.length - 1 - i])) {
                result = false;
                break;
            }

        }
        return result;
    }
}
// @lc code=end
