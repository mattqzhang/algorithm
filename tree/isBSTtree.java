/*
Check if a binary tree is a BST
We can do it recursively, and passing the min/max value in each sub tree.
We can also use an in order traversal to find out.

lc 98
https://leetcode.com/problems/validate-binary-search-tree/description/
*/

// recursive, check the range of each subtree
    
    boolean dfs(TreeNode root, Integer min, Integer max) {
        if(root==null)
            return true;

        if(min != null && root.val <= min) return false;
        if(max != null && root.val >= max) return false;

        return (dfs(root.left, min, root.val) && dfs(root.right, root.val, max));
    }

    public boolean isValidBST(TreeNode root) {
        return dfs(root, null, null);
    }


    /*  Using in-order traversal
     *  Since in-order traversal should have a sorted output,
     *  each value should be bigger than the previous value.
     */

    // keep a record of the previously visited node.
    TreeNode prev = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        
        if (!isValidBST(root.left)) return false;
        
        if (prev != null && root.val <= prev.val) return false;
        
        prev = root;
        return isValidBST(root.right);
    }
