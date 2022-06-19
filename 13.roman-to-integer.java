import java.util.HashMap;

/*
 * @lc app=leetcode id=13 lang=java
 *
 * [13] Roman to Integer
 */

// @lc code=start
class Solution {
    public static HashMap<String, Integer> romaMap = new HashMap<String, Integer>() {
        {
            put("I", 1);
            put("V", 5);
            put("X", 10);
            put("L", 50);
            put("C", 100);
            put("D", 500);
            put("M", 1000);
        }
    };

    public int romanToInt(String s) {
        int result = 0;
        final String[] romanInputArr = s.split("");
        for (int i = 0; i < romanInputArr.length; i++) {
            final Integer n1 = romaMap.get(romanInputArr[i]);
            final Integer n2 = romaMap.get(i == romanInputArr.length - 1 ? "Z" : romanInputArr[i + 1]);
            if (n2 == null || n1 >= n2)
                result += n1;
            else
                result -= n1;
        }

        return result;
    }
}
// @lc code=end
