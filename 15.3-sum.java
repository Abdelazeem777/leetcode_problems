import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int numsLength = nums.length;
        if (numsLength < 3)
            return new ArrayList<List<Integer>>();

        final var resultsSet = new HashSet<List<Integer>>();

        Arrays.sort(nums);

        int startIndex = 0;
        int endIndex = numsLength - 1;

        Integer oldStart = null;
        Integer oldEnd = null;

        while (true) {
            final int start = nums[startIndex];

            if (start > 0 || startIndex == endIndex)
                break;

            final int end = nums[endIndex];

            if (oldStart == null && oldEnd == null) {
                oldStart = start;
                oldEnd = end;
            } else if (oldStart == start && oldEnd == end) {
                endIndex--;
                continue;
            }

            final int expectedMid = -(start + end);
            final int expectedMidIndex = _getIndexFromSortedList(expectedMid,
                    Arrays.copyOfRange(nums, startIndex + 1, endIndex)) + startIndex + 1;

            if (expectedMidIndex != -1 && expectedMidIndex > startIndex && expectedMidIndex < endIndex) {
                resultsSet.add(Arrays.asList(new Integer[] { start, expectedMid, end }));
            }

            endIndex--;

            if (end < 0 || (endIndex == startIndex && start <= 0)) {
                startIndex++;
                endIndex = numsLength - 1;
            }

        }

        return new ArrayList<List<Integer>>(resultsSet);
    }

    private static int _getIndexFromSortedList(int element, int[] sortedArr) {
        int startIndex = 0;
        int endIndex = sortedArr.length - 1;

        while (startIndex <= endIndex) {
            final int midIndex = (startIndex + endIndex) / 2;
            final int mid = sortedArr[midIndex];

            if (mid == element)
                return midIndex;
            else if (mid < element)
                startIndex = midIndex + 1;
            else
                endIndex = midIndex - 1;
        }
        return -1;
    }
}
// @lc code=end
