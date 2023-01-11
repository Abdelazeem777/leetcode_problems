/*
 * @lc app=leetcode id=19 lang=java
 *
 * [19] Remove Nth Node From End of List
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            if (n == 1)
                return null;
            return head;
        }
        var rootHead = head;
        ListNode leftTrimHead = null;
        ListNode rightTrimHead = null;
        int counterToStartPointing = 0;

        while (head != null) {

            if (counterToStartPointing == n - 2)
                rightTrimHead = rootHead;
            else if (rightTrimHead != null && rightTrimHead.next != null)
                rightTrimHead = rightTrimHead.next;

            if (counterToStartPointing == n)
                leftTrimHead = rootHead;
            else if (leftTrimHead != null && leftTrimHead.next != null)
                leftTrimHead = leftTrimHead.next;

            head = head.next;

            counterToStartPointing++;
        }

        if (leftTrimHead == null) {
            if (rightTrimHead == null || rightTrimHead == rootHead) {
                return rootHead;
            } else
                return rightTrimHead;
        }

        leftTrimHead.next = rightTrimHead == null ? null : rightTrimHead;

        return rootHead;

    }

    // public class ListNode {
    // int val;
    // ListNode next;

    // ListNode() {
    // }

    // ListNode(int val) {
    // this.val = val;
    // }

    // ListNode(int val, ListNode next) {
    // this.val = val;
    // this.next = next;
    // }
    // }
}

// @lc code=end
