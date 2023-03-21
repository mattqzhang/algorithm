/*
Given the root of a binary tree, return the postorder traversal of its nodes' values.

lc 145
https://leetcode.com/problems/binary-tree-postorder-traversal/description/
*/


    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null)
            return res;

        List<Integer> left = postorderTraversal(root.left);
        if (left.size() != 0)
            res.addAll(left);

        List<Integer> right = postorderTraversal(root.right);
        if (right.size() != 0)
            res.addAll(right);

        res.add(root.val);
        return res;
    }


/* Follow up: Recursive solution is trivial, could you do it iteratively? */

    public List<Integer> postorderTraversal_v2(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null)
            return res;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            // every time when we pop a node, add it at the beginning
            // then node popped/visited later will be in the front.
            res.add(0, cur.val);

            if (cur.left != null) {
                stack.push(cur.left);
            }
            while (cur.right != null) {
                stack.push(cur.right);
            }
        }
        return res;
    }

