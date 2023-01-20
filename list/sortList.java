/*
Sort a linked list using inserting sort

lc 147
https://leetcode.com/problems/insertion-sort-list/
*/

public static ListNode insertionSortList(ListNode head) {
    if(head == null || head.next == null)
        return head;

    // dummy head for result list
    ListNode res = new ListNode(0);
        res.next = head;

    ListNode cur = head.next;
    head.next = null;

    // insert nodes from cur list to res list, one by one
    while(cur != null) {
        // remove head node of cur list, to be the candidate to insert
        ListNode next = cur.next;
        cur.next = null;
        // start from head of result list
        ListNode cur2 = res.next;
        ListNode pre = res;

        while (cur2 != null) {
            // go forward till the insert point
            if (cur.val >= cur2.val) {
                cur2 = cur2.next;
                pre = pre.next;
            } else {  // insert in place
                pre.next = cur;
                cur.next = cur2;
                break;
            }
        }
        // cur is the biggest one, append to end
        if(cur2 == null) {
            pre.next = cur;
        }
        cur = next;
    }
    return res.next;
}

// older solution

public class sortList {

    // make a copy of a node which has the same data
    static myLinkedList copyNode(myLinkedList node) {
        myLinkedList newNode = new myLinkedList();
        newNode.data = node.data;
        newNode.next = null;
        return newNode;
    }

    /* insertion sort a list */
    static myLinkedList sortList_ins(myLinkedList list) {
        myLinkedList newList = new myLinkedList();

        myLinkedList cur = list;
        myLinkedList newNode, curNew;

        // make head of new list
        if (cur != null) {
            newNode = copyNode(cur);
            newList = newNode;
        } else
            return newList;

        // go through the values in the given list
        while (cur.next != null) {
            newNode = copyNode(cur.next);

            // traverse and compare with each node in the new list
            curNew = newList;

            // smaller than the head, insert as new head
            if (newNode.data < curNew.data) {
                newNode.next = curNew;
                newList = newNode;
            } else {
                // insert at proper position
                while ((curNew.next != null)
                        && (newNode.data > curNew.next.data))
                    curNew = curNew.next;

                myLinkedList nextNode = curNew.next;
                curNew.next = newNode;
                newNode.next = nextNode;
            }
            // go to the next value in the given list
            cur = cur.next;
        }
        return newList;
    }

}


