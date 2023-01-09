/*
Second Minimum nodes in a Binary Tree;
Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes. More formally, the property root.val = min(root.left.val, root.right.val) always holds. Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.

lc 671
*/

int min2 = -1;

void dfs(TreeNode root, int min1){
    if(root != null) {
        if (root.val > min1 && (min2 == -1 || root.val < min2))
            min2 = root.val;
        else if (root.val == min1){
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
