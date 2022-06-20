import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        List<String> longestSubStringArr = new ArrayList<String>();
        int lengthOfLongest = 0;

        final String[] sArr = s.isEmpty() ? new String[0] : s.split("");

        for (int i = 0; i < sArr.length; i++) {
            for (int j = i; j < sArr.length; j++) {
                final String letter = sArr[j];
                if (longestSubStringArr.contains(letter)) {
                    if (lengthOfLongest < longestSubStringArr.size())
                        lengthOfLongest = longestSubStringArr.size();

                    longestSubStringArr.clear();
                    break;

                }
                longestSubStringArr.add(letter);
            }
        }

        return lengthOfLongest > longestSubStringArr.size() ? lengthOfLongest : longestSubStringArr.size();
    }
}
// @lc code=end
