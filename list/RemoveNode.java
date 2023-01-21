/*
Remove n-th node from end
*/

public ListNode removeNthFromEnd(ListNode head, int n) {
    if (head == null)
        return null;

    ListNode first = head, second = head;
    // move first to node n
    while(n > 1 && first.next != null){
        first = first.next;
        n--;
    }
    // first is already at the tail, n is bigger than list length.
    if(n>1)
        return null;

    // n == array length, remove head
    if(first.next == null)
        return head.next;

    first = first.next;
    // move both pointers, till first to end, then second is (n+1)-th from back
    while(first.next != null) {
        first = first.next;
        second = second.next;
    }
    second.next = second.next.next;

    return head;
}
