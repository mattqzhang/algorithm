/*
Diameter of Binary Tree
The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
*/

int max;

public int diameterOfBinaryTree(TreeNode root) {
    max = 0;
    dfs(root);
    // edge is node -1
    return max-1;
}

public int dfs(TreeNode root){
    if(root == null)
        return 0;

    int left = dfs(root.left);
    int right = dfs(root.right);
    max = Math.max(max, left + right + 1);
    return Math.max(left, right) + 1;
}

