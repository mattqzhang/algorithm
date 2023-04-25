/*
Merge two sorted lists

lc 21
https://leetcode.com/problems/merge-two-sorted-lists/description
*/

//recursion
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if(l1 == null)
        return l2;
    if(l2 == null)
        return l1;

    if(l1.val <= l2.val) {
        l1.next = mergeTwoLists(l1.next, l2);
        return l1;
    } else{
        l2.next = mergeTwoLists(l1, l2.next);
        return l2;
    }
}

// iteration
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode head = new ListNode(-1);
    ListNode cur = head;
    while(l1 != null && l2 != null){
        if(l1.val <= l2.val){
            cur.next = l1;
            l1 = l1.next;
        }else{
            cur.next = l2;
            l2 = l2.next;
        }
        cur = cur.next;
    }
    cur.next = l1 == null ? l2 : l1;

    return head.next;
}
