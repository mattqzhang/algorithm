/*
Rotate List
Given a linked list, rotate the list to the right by k places, where k is non-negative.

lc 61
https://leetcode.com/problems/rotate-list/
*/

    public ListNode rotateRight(ListNode head, int k) {
       if(head == null)
            return null;

        ListNode tail = head;
        int ct = 1;
        while(tail.next != null) {
            tail = tail.next;
            ct ++;
        }

        k = k % ct;
        if(k==0)
            return head;

        ListNode newTail = head, newHead;
        ct = ct - k;
        while(ct > 1){
           newTail = newTail.next; 
           ct --;
        }
        newHead = newTail.next;
        tail.next = head;
        newTail.next = null;
        return newHead;
    }
