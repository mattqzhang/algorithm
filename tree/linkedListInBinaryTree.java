/*
Linked List in Binary Tree
Given a binary tree root and a linked list with head as the first node. 
Return True if all the elements in the linked list starting from the head correspond to some downward path connected in the binary tree otherwise return False.
In this context downward path means a path that starts at some node and goes downwards.

lc 1367
https://leetcode.com/problems/linked-list-in-binary-tree/description/
*/

    // matches whole word
    public boolean matchFromRoot(ListNode head, TreeNode root) {
        if (head == null) return true;
        if (root == null) return false;

        if (head.val == root.val) {
            return matchFromRoot(head.next, root.left) || matchFromRoot(head.next, root.right);
        } else
            return false;
    }
    
    // if first value match, then check if match whole word
    // otherwise recursive call.
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null) return true;
        if (root == null) return false;

        if (head.val == root.val 
                && (matchFromRoot(head.next, root.left) 
                    || matchFromRoot(head.next, root.right)))
            return true;
        
        return isSubPath(head, root.left) || isSubPath(head, root.right);
    }
