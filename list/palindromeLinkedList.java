/*
Given the head of a singly linked list, return true if it is a 
palindrome or false otherwise.

lc 234
https://leetcode.com/problems/palindrome-linked-list/description/
*/

// solution 1, copy the list to an ArrayList, then use two pointers from front and back, and compare
// trivial, omit here.

// solution 2: recursive
// use a front pointer to move from head to tail,
// the recursive part will go to tail first, and match with the front pointer
// then in each nested call, the recurisve part move back one node, 
// and we manually move the front pointer forward one node, then they'll match

public class test1 {

    private ListNode front;

    private boolean recursiveCheck(ListNode cur) {
        if (cur == null) return true;
        
        // the cur will move the tail first, in the recursive call
        if (!recursiveCheck(cur.next)) return false; 

        // compare cur with front
        if (!(cur.val == front.val)) return false;

        // move front forward, and cur will move backward after getting out of this call
        front = front.next;

        return true;
    }

    public boolean isPalindrome(ListNode head) {
        front = head;
        return recursiveCheck(head);
    }


   // debug code 
   public static void main(String[] args) {

        ListNode head = new ListNode(5);
        ListNode cur = head;
        cur.next = new ListNode(6);
        cur = cur.next;
        cur.next = new ListNode(1);
        cur = cur.next;
        cur.next = new ListNode(7);
        cur = cur.next;
        cur.next = new ListNode(5);

        test1 obj = new test1();
        obj.isPalindrome(head);

        System.out.println("\ndone");
    }
}
