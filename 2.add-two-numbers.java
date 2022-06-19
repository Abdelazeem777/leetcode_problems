/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
 */

// @lc code=start

// Definition for singly-linked list.
// public class ListNode {
//     int val;
//     ListNode next;

//     ListNode() {
//     }

//     ListNode(int val) {
//         this.val = val;
//     }

//     ListNode(int val, ListNode next) {
//         this.val = val;
//         this.next = next;
//     }
// }

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        final ListNode firstNode = new ListNode();
        boolean prevMoreThan10 = false;

        ListNode currentNodeResult = firstNode;

        ListNode currentNode1 = l1;
        ListNode currentNode2 = l2;

        while (currentNode1 != null || currentNode2 != null || prevMoreThan10) {
            final int n1 = currentNode1 == null ? 0 : currentNode1.val;
            final int n2 = currentNode2 == null ? 0 : currentNode2.val;

            final int sum = n1 + n2 + (prevMoreThan10 ? 1 : 0);

            if (sum > 9) {
                currentNodeResult.val = sum - 10;
                prevMoreThan10 = true;
            } else {
                currentNodeResult.val = sum;
                prevMoreThan10 = false;
            }

            if (currentNode1 != null)
                currentNode1 = currentNode1.next;

            if (currentNode2 != null)
                currentNode2 = currentNode2.next;

            if (currentNode1 == null && currentNode2 == null && !prevMoreThan10)
                break;

            final ListNode newNode = new ListNode();

            currentNodeResult.next = newNode;
            currentNodeResult = newNode;

        }

        return firstNode;

    }

}

// @lc code=end
