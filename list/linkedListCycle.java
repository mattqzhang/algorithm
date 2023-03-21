/*
Given head, the head of a linked list, determine if the linked list has a cycle in it.

lc 141
https://leetcode.com/problems/linked-list-cycle/description/
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode first = head, second = head;
        while(second != null) {
            second = second.next;
            if (second == null) {
                return false;
            } else {
                second = second.next;
            }
            first = first.next;
            if (first == second) return true;
        }
        return false;    
    }
}
