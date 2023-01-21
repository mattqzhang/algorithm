/*
Reorder linked list
Reorder linked list from both ends to middle. 
Example:Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 *
 Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 Example:
 Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 */
public static void reorderList(ListNode head) {
    if(head == null || head.next == null)
        return;

    // find the middle node
    ListNode slow = head, fast = head;
    while(fast.next != null && fast.next.next != null){
        slow = slow.next;
        fast = fast.next.next;
    }

    // reverse sublist from slow.next to tail
    ListNode p = null, q = slow.next;
    slow.next = null;
    while(q !=null){
        ListNode r = q.next;
        q.next = p;
        p = q;
        q = r;
    }
    // now p is the head of right half after reversing,
    // and we have two lists starting from head, and q

    // reorder
    ListNode left = head, right = p;
    while(right != null){
        ListNode leftNext = left.next, rightNext = right.next;
        left.next = right;
        right.next = leftNext;
        left = leftNext;
        right = rightNext;
    }
}
