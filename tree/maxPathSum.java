/*
Binary Tree maximum Path sum.
Given a non-empty binary tree, find the maximum path sum.
The path may be from any node in the tree, to any other node in the tree

lc 124:
https://leetcode.com/problems/binary-tree-maximum-path-sum/
*/

// another solution

class Solution {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxDepth(root);
        return max;
    }
    
    private int maxDepth(TreeNode root) {
        if (root == null) return 0;

        // maxDepth() may return negative value, so need the Math.max()
        int left = Math.max(maxDepth(root.left), 0);
        int right = Math.max(maxDepth(root.right), 0);

        // check if the current node with it's left and right child is a max path
        max = Math.max(left+right+root.val, max);

        // return a single path to its parent call
        return Math.max(left, right) + root.val;
    }
}


