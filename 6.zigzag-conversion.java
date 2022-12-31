/*
 * @lc app=leetcode id=6 lang=java
 *
 * [6] Zigzag Conversion
 */

// @lc code=start
class Solution {
    public String convert(String s, int numRows) {

        int sLength = s.length();
        final int numColumn = numRows == 1 ? sLength : (sLength / 2) + 1;

        final char[][] my2DArray = new char[numRows][numColumn];

        final char[] splittedString = s.toCharArray();

        int stringIndex = 0;

        for (int i = 0; i < numColumn; i++) {
            final int indexBetweenLine = numRows == 1 ? 0 : i % (numRows - 1);

            for (int j = 0; j < numRows; j++) {
                if ((indexBetweenLine == 0 || numRows - 1 - indexBetweenLine == j) && stringIndex < sLength) {
                    my2DArray[j][i] = splittedString[stringIndex++];
                }
            }
        }

        String result = "";

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumn; j++) {
                final char myChar = my2DArray[i][j];
                if (myChar != '\u0000')
                    result += myChar;
            }
        }

        return result;
    }
}
// @lc code=end
