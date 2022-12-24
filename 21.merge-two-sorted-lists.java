/*
 * @lc app=leetcode id=21 lang=java
 *
 * [21] Merge Two Sorted Lists
 */

// @lc code=start

//Definition for singly-linked list.

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode mergedList = new ListNode(list1.val < list2.val ? list1.val : list2.val);
        if (list1.next == null && list2.next == null)
            return mergedList;
        final ListNode headMergedList = mergedList;
        ListNode currentNode1 = list1.val < list2.val ? list1.next : list1;
        ListNode currentNode2 = list1.val < list2.val ? list2 : list2.next;

        while (currentNode1 != null || currentNode2 != null) {
            if (currentNode2 == null || currentNode1.val < currentNode2.val) {
                mergedList = mergedList.next = new ListNode(currentNode1.val);
                currentNode1 = currentNode1.next;
            } else {
                mergedList = mergedList.next = new ListNode(currentNode2.val);
                currentNode2 = currentNode2.next;
            }
        }
        return headMergedList;
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
