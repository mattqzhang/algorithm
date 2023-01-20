/*
Reverse a linked list.
We can do it recursively, or non-recursively changing pointers one by one

lc 206:
https://leetcode.com/problems/reverse-linked-list/description/
*/


public class reverseList {

    // non recursive version to reverse linked list
    // go through the list and change the pointers one by one
    static myLinkedList reverseLL(myLinkedList head){      
        if(head == null)
            return null;
      
        myLinkedList p, q, r;
        p = null;
        q = head;
        while(q != null){
            r = q.next;
            q.next = p;
            p = q;
            q = r;
        }
      
        head = p;
        return head;
    }
      
    // recursive version to reverse linked list
    static myLinkedList revList_rec(myLinkedList cur){
        if(cur == null)
            return null;
       
        // last node, return this as new head
        if(cur.next == null) 
            return cur;       
      
        //we keep a record of the next node, which will be the tail of the new list.
        //then when we return, simply attach the current node to the tail, O(N)
        myLinkedList curNext = cur.next;
        myLinkedList head = revList_rec(curNext);  
        curNext.next = cur;
        //reset tail otherwise we'll get a cycle
        cur.next = null;
        return head;
    }
  
    static final int arr[] = { 5, 2, 6, 9, 3, 11, 1, 4, 8, 7, 10, 12 };      
   
    public static void main(String[] args) {
        simpleLinkedList simpLL = new simpleLinkedList();
        myLinkedList head = simpLL.buildList(arr);
        System.out.println("original list: ");
        simpLL.printList(head);
      
        head = reverseLL(head);
        System.out.println("\nrevesed list: ");
        simpLL.printList(head);

        //rebuild the orignal list
        head = simpLL.buildList(arr);       
      
        head = revList_rec(head);      
        System.out.println("\nrevesed list by recursion: ");
        simpLL.printList(head);
    }
}
