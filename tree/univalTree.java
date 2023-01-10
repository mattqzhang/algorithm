/*
Unival Binary Tree
Check if a BTree is unival (all values are the same), or count the number of all unival subtrees.
*/

/** check if a tree is Unival **/
boolean isUnival(TreeNode root){
    if(root == null)
        return true;

    if(root.left != null && root.val != root.left.val)
        return false;
    if(root.right != null && root.val != root.right.val)
        return false;

    return isUnival(root.left) && isUnival(root.right);
}
/** Count # of unival subtrees **/
int count = 0;

boolean uniCt(TreeNode node) {
    boolean is_unival = true;
    // check if all of the node's children are univalue subtrees and if they have the same value
    // also recursively call is_uni for children
    if (node.left != null) {
        is_unival = node.left.val == node.val && uniCt(node.left);
    }
    if(!is_unival)
       return false;

    if (node.right != null) {
        is_unival = node.right.val == node.val && uniCt(node.right);
    }

    // not unival, don't increase ct
    if (!is_unival)
        return false;

    // current tree is unival, increase ct
    count++;
    return true;
}

public int countUnivalSubtrees(TreeNode root) {
    if (root == null) 
        return 0;
    uniCt(root);
    return count;
}
