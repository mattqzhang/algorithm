/*
Sum of Left Leaves
Given the root of a binary tree, return the sum of all left leaves.

lc 404
https://leetcode.com/problems/sum-of-left-leaves/description/
*/

    public int dfs(TreeNode node, boolean isLeft) {
        int sum = 0;

        // this is a leaf
        if (isLeft && node.left == null && node.right == null)
            return node.val;

        if (node.left != null)
            sum += dfs(node.left, true);
        if (node.right != null)
            sum += dfs(node.right, false);
        return sum;

    }

    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if (root == null)
            return 0;
        return dfs(root, false);
    }
