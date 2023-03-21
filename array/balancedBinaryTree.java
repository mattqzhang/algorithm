/*
110. Balanced Binary Tree
Given a binary tree, determine if it is height-balanced
A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.

lc 110
https://leetcode.com/problems/balanced-binary-tree/
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
         if (root == null) return true;
         if (Math.abs(getDepth(root.left) - getDepth(root.right)) > 1)
             return false;
         return isBalanced(root.left) && isBalanced(root.right);

    }

    public int getDepth(TreeNode root) {
         if (root == null)
             return 0;
         return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }
}
