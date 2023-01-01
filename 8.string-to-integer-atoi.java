/*
 * @lc app=leetcode id=8 lang=java
 *
 * [8] String to Integer (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String s) {
        final int sLength = s.length();

        if (sLength == 0)
            return 0;

        final char[] charArr = s.toCharArray();
        String res = "";
        boolean isNegative = false;
        boolean signIsSet = false;

        for (int i = 0; i < charArr.length; i++) {
            char myChar = charArr[i];
            if (myChar == ' ')
                if (!res.isEmpty() || signIsSet)
                    break;
                else
                    continue;

            if (!signIsSet && (myChar == '+' || myChar == '-') && res.isEmpty()) {
                isNegative = myChar == '-';
                signIsSet = true;
                continue;
            }

            if (Character.isLetter(myChar) || myChar == '+' || myChar == '-')
                break;

            res += myChar;

        }

        double result = res.isEmpty() ? 0.0 : Double.parseDouble(res);

        result = (isNegative ? -result : result);

        if (result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        else if (result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        return (int) result;
    }

}
// @lc code=end
