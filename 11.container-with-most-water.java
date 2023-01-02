
/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int res = 0;
        int longestHight = 0;
        for (int i = 0; i < height.length - 1; i++) {
            int iHeight = height[i];
            if (iHeight > longestHight)
                longestHight = iHeight;
            else
                continue;
            for (int j = i + 1; j < height.length; j++) {
                int jHeight = height[j];
                int candidate = (jHeight < iHeight ? jHeight : iHeight) * (j - i);
                if (candidate > res)
                    res = candidate;
            }
        }
        return res;
    }
}
// @lc code=end
