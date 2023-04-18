/*
Kth Smallest Element in a BST

lc 230
https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
*/


// in order traversal to get the sorted arraylist, then get k
    public void inorder(TreeNode root, ArrayList<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
    
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list.get(k-1);
    }

// solution 2: using stack

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stk = new Stack<>();
        TreeNode cur = root;
        int ct = 0;

        while (true) {
            if (cur != null) {
                stk.push(cur);
                cur = cur.left;
            } else if (!stk.isEmpty()) {
                cur = stk.pop();
                ct ++;
                if (ct == k) {
                    return cur.val;
                }
                cur = cur.right;
            } else 
                break;
        }
        return -1;
    }
