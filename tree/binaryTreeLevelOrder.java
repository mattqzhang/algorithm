/*
Binary Tree Level Order Traversal

lc 102
https://leetcode.com/problems/binary-tree-level-order-traversal/description/
*/

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null)
            return res;

        List<TreeNode> cur = new LinkedList<>();
        cur.add(root);
        List<Integer> vals = new LinkedList<>();
        vals.add(root.val);
        res.add(vals);
        
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
                res.add(vals);
                cur = children;
            } else
                break;            
        }
        return res;
    }
