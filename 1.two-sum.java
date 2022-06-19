/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {

            final int n1 = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                final int n2 = nums[j];
                if (n1 + n2 == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] {};

    }
}
// @lc code=end
