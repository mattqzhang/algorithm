/*
Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.

lc 83
https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = head, cur = head;
        while (cur!= null && cur.next != null) {
            cur = cur.next;
            while (cur!=null && pre.val == cur.val) {
                cur = cur.next;
            }
            pre.next = cur;
            pre = cur;
        }
        return head;        
    }
}
