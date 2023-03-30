/*
Binary Tree Zigzag Level Order Traversal
Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

lc 103
https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
*/

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null)
            return res;

        List<TreeNode> cur = new LinkedList<>();
        cur.add(root);
        List<Integer> vals = new LinkedList<>();
        vals.add(root.val);
        res.add(vals);
        boolean turn = true;

        //while(!cur.isEmpty()) {
        while(true) {
            List<TreeNode> children = new LinkedList<>();
            vals = new LinkedList<>();
            for (TreeNode node : cur) {
                if (node.left != null) {
                    children.add(node.left);
                    vals.add(node.left.val);
                }
                if (node.right != null) {
                    children.add(node.right);
                    vals.add(node.right.val);
                }
            }
            if (!vals.isEmpty()){
                if (turn) {
                    Collections.reverse(vals);                    
                }
                turn = !turn;
                res.add(vals);
                cur = children;
            } else
                break;
        }
        return res;        
    }
