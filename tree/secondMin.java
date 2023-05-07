/*
Second Minimum nodes in a Binary Tree;
Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes. More formally, the property root.val = min(root.left.val, root.right.val) always holds. Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.

lc 671
https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/description/
*/

    int[] min;
    void dfs(TreeNode root) {
        if (root == null) return;
        
        if (min[0] == -1 || root.val < min[0]) {            
            min[1] = min[0];
            min[0] = root.val;
        } else if (root.val > min[0] && 
                (min[1] == -1 || root.val < min[1])) {
            min[1] = root.val;
        }
        dfs(root.left);
        dfs(root.right);
    }

    public int findSecondMinimumValue(TreeNode root) {
         min = new int[]{-1, -1};
         dfs(root);
         return min[1];
    }


// a similar solution

int min2 = -1;

void dfs(TreeNode root, int min1){
    if(root != null) {
        if (root.val > min1 && (min2 == -1 || root.val < min2))
            min2 = root.val;
        else if (root.val == min1){
            // because root.val = min(root.left.val, root.right.val)
            // we only need to check if it's children has a smaller value, or same as root
            dfs(root.left, min1);
            dfs(root.right, min1);
        }
    }
}

public int findSecondMinimumValue(TreeNode root) {
    if(root == null)
        return -1;

    int min1 = root.val;
    dfs(root, min1);
    return min2 == -1 ? -1 : min2;
}
