/*
Flatten a Multilevel Doubly Linked List
Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are given the head of the first level of the list.

lc 430
https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
*/

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};

/* dfs */
class Solution {
    public Node flatten(Node head) {
        if (head == null) return null;
        flattenDFS(head);
        return head;
    }

    /* pre-order, DFS, return the tail of the flatten list */
    public Node flattenDFS(Node curr) {

        if (curr.child == null && curr.next == null)
            return curr;

        if (curr.child == null)  // then next is not null
            return flattenDFS(curr.next);

        // child is not null, dfs into it as left tree

        // relabel left and right tree
        Node rightTree = curr.next;
        Node leftTree = curr.child;
        curr.child = null;

        curr.next = leftTree;
        leftTree.prev = curr;        

        // dfs to get tail
        Node tail = flattenDFS(leftTree);        

        if (rightTree == null) 
            return tail;

        // dfs to right tree        
        tail.next = rightTree;
        rightTree.prev = tail;
        return flattenDFS(rightTree);
    }
}

/*
use stack, operations like below:
       Push 1            S: 1
Pop 1, push 2            S: 2
Pop 2, push 3            S: 3
Pop 3, push 4, push 7    S: 7, 4
Pop 7, push 8            S: 8, 4
Pop 8, push 9, push 11   S: 11, 9, 4
Pop 11, push 12          S: 12, 9, 4
Pop 12                   S: 9, 4
Pop 9, push 10           S: 10, 4
Pop 10                   S: 4
Pop 4, push 5            S: 5
Pop 5, push 6            S: 6
Pop 6

So the final order is same as the pop order.
Every time we pop a node, we attach to the list by connecting it
 with the previously popped node(tail), and make it the new tail
*/

    // Solve by iteration
    public Node flatten(Node head) {
        if (head == null) return null;

        Stack<Node> stack = new Stack<>();
        Node tail = head, curr = head;
        if (curr.next != null)
          stack.push(curr.next);
        if (curr.child != null){
          stack.push(curr.child);
          curr.child = null;
        }

        while (!stack.isEmpty()) {
            // every time we pop a node,
            //   connect with tail (the previous popped value)
            curr = stack.pop();
            tail.next = curr;
            curr.prev = tail;
            tail = curr; 

            if (curr.next != null)
                stack.push(curr.next);
            // left child on top of the stack
            if (curr.child != null) {
                stack.push(curr.child);
                // don't forget to remove all child pointers.
                curr.child = null;
            }
        }
        return head;
    }
