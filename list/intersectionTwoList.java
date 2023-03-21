/*
Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.

lc 160
https://leetcode.com/problems/intersection-of-two-linked-lists/description/
*/

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = 0, len2 = 0;

        // get length of two lists
        ListNode cur = headA;
        while (cur != null) {
            cur = cur.next;
            len1 ++;
        }        
        cur = headB;
        while (cur != null) {
            cur = cur.next;
            len2 ++;
        }
        
        // find the diff, and skip the longer list to the same size to shorter one
        int diff = 0;
        if (len1 >= len2) {
            diff = len1 - len2;
            while(diff >0) {
              headA = headA.next;
              diff --;
            }
        } else {
            diff = len2 - len1;
            while(diff > 0) {
                headB = headB.next;
                diff --;
            }
        }

        // move both header till they meet
        while(headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
