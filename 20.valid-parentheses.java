import java.util.HashMap;

/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start
class Solution {
    static char[] openBracketsChars = new char[] { '(', '{', '[' };
    static HashMap<Character, Character> openCloseMap = new HashMap<Character, Character>() {
        {
            put('(', ')');
            put('{', '}');
            put('[', ']');
        }
    };

    public boolean isValid(String s) {
        if (s.isEmpty())
            return true;

        final int stringLength = s.length();

        int openedBracketsCharsRealLength = 0;
        final char[] openedBrackets = new char[stringLength];

        for (int i = 0; i < stringLength; i++) {
            final char c = s.charAt(i);
            if (isOpened(c))
                openedBrackets[openedBracketsCharsRealLength++] = c;
            else if (openedBracketsCharsRealLength == 0)
                return false;
            else if (openCloseMap.get(openedBrackets[openedBracketsCharsRealLength - 1]).equals(c))
                openedBrackets[--openedBracketsCharsRealLength] = '-';
            else
                return false;
        }

        return openedBracketsCharsRealLength == 0;

    }

    public static boolean isOpened(char item) {

        for (char c : openBracketsChars)
            if (c == item)
                return true;
        return false;
    }
}
// @lc code=end
