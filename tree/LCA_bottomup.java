/*
Find Lowest Common Ancestor(LCA) of two given nodes A, B in a binary tree.
Without parent pointer:
We can recursively check a node is LCA by checking if the values are in both subtrees or all in one subtree.
The checking is done bottom up, and passing up to the root.
*/


    /* When there's no parent pointer, we can find the LCA bottom up.
     * We find the matching values, then pass up.
     * The call is done recursively.
     */
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if(root == null)
        return null;

    // bottom case: find the node
    if(root.val == p.val || root.val == q.val)
        return root;

    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);

    if(left == null)
        return right;

    if(right == null)
        return left;

    // the nodes found are in both subtrees, so root is the parent
    return root;
}


/* special case for BST, do it top down, much faster  */
    static BSTtree bstLCA(BSTtree root, BSTtree NodeA, BSTtree NodeB){
        if(root == null || NodeA == null || NodeB == null)
            return null;
       
        if(root.value > NodeA.value && root.value > NodeB.value)
            return bstLCA((BSTtree)root.left, NodeA, NodeB);
        else if(root.value < NodeA.value && root.value < NodeB.value)
            return bstLCA((BSTtree)root.right, NodeA, NodeB);
        else
            return root;
    }

