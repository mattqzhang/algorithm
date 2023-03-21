/*
Given the root of a binary tree, return the preorder traversal of its nodes' values.

lc 144
https://leetcode.com/problems/binary-tree-preorder-traversal/description/
*/

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null)
            return res;

        res.add(root.val);
        List<Integer> left = preorderTraversal(root.left);
        if (left.size() != 0)
            res.addAll(left);
        List<Integer> right = preorderTraversal(root.right);
        if (right.size() != 0)
            res.addAll(right);
        return res;
    }


   /* Follow up: Recursive solution is trivial, could you do it iteratively? */
    public List<Integer> preorderTraversal(TreeNode root) {
        // non recursive
        List<Integer> res = new LinkedList<>();
        if (root == null)
            return res;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            // add right to stack first
            if (node.right !=null )
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }

        return res;
    }


    // my original complex version:

    public List<Integer> preorderTraversal_itr(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null)
            return res;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        // push all the left children
        while (node != null) {
            res.add(node.val);
            stack.push(node);
            node = node.left;
        }

        // work on the stack
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            // get the right child of the popped node
            if (top.right != null) {
                top = top.right;
                while (top != null) {
                    // add cur value(pre), then push all the left children
                    res.add(top.val);
                    stack.push(top);
                    top = top.left;
                }
            }
        }
        return res;
    }
