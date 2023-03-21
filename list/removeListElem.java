/*
Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.

lc 203
https://leetcode.com/problems/remove-linked-list-elements/description/
*/

    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) return null;

        // now head.val != val;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            while (next != null && next.val == val) {
                next = next.next;
            }
            cur.next = next;
            cur = next;
        }
        return head;        
    }
