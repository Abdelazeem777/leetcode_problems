/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0)
            return getMedian(nums2);

        if (nums2.length == 0)
            return getMedian(nums1);

        final int[] mergedList = mergeArrays(nums1, nums2);
        return getMedian(mergedList);

    }

    private static int[] mergeArrays(int[] arr1, int[] arr2) {
        final int[] result = new int[arr1.length + arr2.length];
        for (int i = 0, j = 0; i + j < result.length;) {
            if (i >= arr1.length) {
                result[i + j] = arr2[j];
                j++;
            } else if (j >= arr2.length) {
                result[i + j] = arr1[i];
                i++;
            } else if (arr1[i] <= arr2[j]) {
                result[i + j] = arr1[i];
                i++;
            } else {
                result[i + j] = arr2[j];
                j++;
            }
        }
        return result;
    }

    private static double getMedian(int[] arr) {
        final boolean isEven = arr.length % 2 == 0;
        final int pivotIndex = arr.length / 2;

        if (isEven)
            return ((double) arr[pivotIndex - 1] + (double) arr[pivotIndex]) / 2;
        else
            return arr[pivotIndex];
    }

}
// @lc code=end
