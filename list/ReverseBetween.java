/*
Reverse a linked list between position m and n

Note: 1 ≤ m ≤ n ≤ length of list.
Example:
Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL

lc 92:
https://leetcode.com/problems/reverse-linked-list-ii/description/
*/

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
    // Empty list
    if (head == null) {
        return null;
    }

    // Move the two pointers until they reach the proper starting point in the list.
    ListNode cur = head, prev = null;
    int i = 1;
    while (i < left ) {
        prev = cur;
        cur = cur.next;
        i++;        
    }

    // The two pointers that will fix the final connections.
    // start is the node before m, and tail will be the tail of the reversed list
    ListNode start = prev, tail = cur;

    // Iteratively reverse the nodes until n becomes 0,
    // Finally pre is the head of the reversed part, and cur is the next node after the reversed part
    ListNode r = null;
    while (i <= right) {
        r = cur.next;
        cur.next = prev;
        prev = cur;
        cur = r;
        i++;
    }

    // Fit the reversed part between start and tail into the original list.
    if (start != null) {
        start.next = prev;
    } else {
        head = prev;
    }

    tail.next = cur;
    return head;
        
    }
}
