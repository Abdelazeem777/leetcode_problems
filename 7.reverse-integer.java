/*
 * @lc app=leetcode id=7 lang=java
 *
 * [7] Reverse Integer
 */

// @lc code=start
class Solution {
    public int reverse(int x) {
        if (exceedLimits(x))
            return 0;

        final boolean isNegative = x < 0;

        int xAbs = Math.abs(x);

        final String[] resString = String.valueOf(xAbs).split("");

        String reversedResString = "";

        for (int i = 0; i < resString.length; i++)
            reversedResString += resString[resString.length - i - 1];

        final double result = Double.parseDouble(reversedResString);
        if (exceedLimits(result))
            return 0;

        return (int) (isNegative ? -result : result);
    }

    public static boolean exceedLimits(double input) {
        double min = -Math.pow(2, 31);
        double max = Math.pow(2, 31) - 1;
        return (input <= min || input >= max);
    }
}
// @lc code=end
