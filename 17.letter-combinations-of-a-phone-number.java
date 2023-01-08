import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 */

// @lc code=start
class Solution {
    static HashMap<Character, String[]> mapper = new HashMap<Character, String[]>() {
        {
            put('2', new String[] { "a", "b", "c" });
            put('3', new String[] { "d", "e", "f" });
            put('4', new String[] { "g", "h", "i" });
            put('5', new String[] { "j", "k", "l" });
            put('6', new String[] { "m", "n", "o" });
            put('7', new String[] { "p", "q", "r", "s" });
            put('8', new String[] { "t", "u", "v" });
            put('9', new String[] { "w", "x", "y", "z" });

        }
    };

    public List<String> letterCombinations(String digits) {

        final List<String> result = new ArrayList<String>();

        if (digits.isEmpty())
            return result;

        final char[] digitsList = digits.toCharArray();

        final List<String[]> mappedCharsList = new ArrayList<String[]>();

        for (char myChar : digitsList) {
            final String[] mappedChars = mapper.get(myChar);
            if (mappedChars == null)
                continue;
            mappedCharsList.add(mappedChars);
        }

        final int mappedCharsListSize = mappedCharsList.size();

        if (mappedCharsListSize == 0)
            return result;
        if (mappedCharsListSize == 1)
            return Arrays.asList(mappedCharsList.get(0));

        final String[] firstCharsList = mappedCharsList.get(0);
        for (int i = 0; i < firstCharsList.length; i++) {
            final String rootCharString = firstCharsList[i];

            final List<String> myCharStringCombinations = _generateListOfStrings(rootCharString,
                    mappedCharsList.subList(1, mappedCharsListSize));
            result.addAll(myCharStringCombinations);
        }

        return result;
    }

    private List<String> _generateListOfStrings(String rootCharString, List<String[]> subList) {
        final List<String> result = new ArrayList<String>();

        final int subListSize = subList.size();
        final String[] charsList = subList.get(0);
        for (int i = 0; i < charsList.length; i++) {
            final String childCharString = charsList[i];
            if (subListSize == 1)
                result.add(rootCharString + childCharString);
            else {
                final List<String> myCharStringCombinations = _generateListOfStrings(rootCharString + childCharString,
                        subList.subList(1, subListSize));
                result.addAll(myCharStringCombinations);
            }
        }

        return result;
    }

}
// @lc code=end
