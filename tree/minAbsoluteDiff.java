/*
Minimum Absolute Difference in BST
Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.In order traversal, and find the min of two adjacent values.

lc 530
https://leetcode.com/problems/minimum-absolute-difference-in-bst/description/
*/

   List<Integer> list;

   // get the sorted in-order list of the BST
   void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }

    public int getMinimumDifference(TreeNode root) {
        list = new ArrayList<>();
        inorder(root);
        int min = Integer.MAX_VALUE;
        for (int i=1; i<list.size(); i++) {
            min = Math.min(min, list.get(i) - list.get(i-1));
        }
        return min;
    }
