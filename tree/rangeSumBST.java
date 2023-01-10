/*
Range Sum BST
Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).
*/

public int rangeSumBST_v1(TreeNode root, int L, int R) {
    int sum = 0;
    if(root == null)
        return sum;

    if(root.val >= L && root.val <= R){
        sum += root.val;
        sum += rangeSumBST_v1(root.left, L, R);
        sum += rangeSumBST_v1(root.right, L, R);
    }else if(root.val < L)
        sum += rangeSumBST_v1(root.right, L, R);
    else // root.val > R
        sum += rangeSumBST_v1(root.left, L, R);

    return sum;
}


public int rangeSumBST(TreeNode root, int L, int R) {
    int sum = 0;
    if(root == null)
        return sum;

    if(root.val >= L && root.val <= R){
        sum += root.val;
    }

    // note that it's not "else if".
    // we only add the root value itself while it's in range,
    // and defer the child node's value to its own call.

    // left tree may still have nodes satisfying
    if(root.val > L)
        sum += rangeSumBST(root.left, L, R);

    // right tree may still have nodes satisfying
    if(root.val < R)
        sum += rangeSumBST(root.right, L, R);

    return sum;
}

