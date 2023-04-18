/*
In order print two BST tree
we can do it by in-order print each tree, then merge sort. But the iterative way is better (true in-order)

lc 1305
https://leetcode.com/problems/all-elements-in-two-binary-search-trees/description/
*/

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        TreeNode cur1 = root1;
        TreeNode cur2 = root2;
        List<Integer> res = new LinkedList<>();

        while (true) {
            while (cur1 != null) {
                stack1.push(cur1);
                cur1 = cur1.left;
            }
            while (cur2 != null) {
                stack2.push(cur2);
                cur2 = cur2.left;
            }

            if (stack1.isEmpty() && stack2.isEmpty())
                break;

            TreeNode next;
            if (stack2.isEmpty() || 
                    (!stack1.isEmpty() && (stack1.peek().val < stack2.peek().val))) {
                next = stack1.pop();
                res.add(next.val);
                cur1 = next.right;
            } else if (!stack2.isEmpty()) {
                next = stack2.pop();
                res.add(next.val);
                cur2 = next.right;                
            }
            
        }
        return res;        
    }
