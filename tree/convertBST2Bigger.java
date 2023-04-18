/*
Convert BST to Greater Tree

lc 538
https://leetcode.com/problems/convert-bst-to-greater-tree/description/
*/

class Solution {
    // global sum, will increase follow dfs from right tree
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) return root;

        root.right = convertBST(root.right);
        sum += root.val; // carry this sum along the dfs path, max to min
        root.val = sum;
        root.left = convertBST(root.left);

        return root;
    }
}
