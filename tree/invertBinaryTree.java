/*
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right= invertTree(tmp);
        return root;        
    }

lc 226
https://leetcode.com/problems/invert-binary-tree/description/
*/


