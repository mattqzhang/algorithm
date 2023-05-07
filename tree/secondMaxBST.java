/*
Find the second largest value in a BST

*/


    public int findSecondLargest(TreeNode root) {
        if (root == null) return -1;
        if (root.left == null && root.right == null)
            return -1;

        TreeNode prev = null;
        TreeNode node = root;

        // Find the rightmost node in the left subtree
        while (node.right != null) {
            prev = node;
            node = node.right;
        }

        // If the rightmost node in the left subtree has no left child,
        // then it is the second largest node.
        if (node.left == null) {
            return prev.val;
        }

        // Otherwise, the second largest node is the rightmost node
        // in the left subtree.
        // We also come here if the root doesn't have right tree
        node = node.left;
        while (node.right != null) {
            node = node.right;
        }
        return node.val;
    }

