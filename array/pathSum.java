/*
Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.

A leaf is a node with no children.

lc 112
https://leetcode.com/problems/path-sum/description/
*/

    public boolean hasPathSum(TreeNode root, int targetSum) {
         if (root == null) return false;

         if (root.left == null && root.right == null)
             return (root.val == targetSum);

         return pathSum(root.left, targetSum, root.val)
                 || pathSum(root.right, targetSum, root.val);
    }

    public boolean pathSum(TreeNode root, int targetSum, int sum) {
         if (root == null) 
             return false;
         
        if (root.left == null && root.right == null)
            return (sum + root.val == targetSum);

        return pathSum(root.left, targetSum, sum + root.val)
                || pathSum(root.right, targetSum, sum + root.val);
    }
