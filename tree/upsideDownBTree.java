/*
Binary Tree Upside Down
Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.

lc 156
https://leetcode.com/problems/binary-tree-upside-down/

Given a binary tree {1,2,3,4,5},
   1
  / \
 2   3
/ \
4 5
return the root of the binary tree [4,5,2,#,#,3,1].
 4
/ \
5  2
  / \
 3   1

*/

/* recursive */
public TreeNode upsideDownBinaryTree(TreeNode root) {
    if(root == null){
        return null;
    }
    if(root.left == null && root.right == null){
        return root;
    }

    TreeNode leftRoot = upsideDownBinaryTree(root.left);
    TreeNode temp =  leftRoot;
    if(leftRoot != null){
        // find right most node for this upsideDown tree
        while(temp.right != null){
            temp = temp.right;
        }
        temp.right = root;
        temp.left = root.right;

        root.left = null;
        root.right = null;
    }

    return leftRoot;
}

/* loop, logic is bit messy */

 public TreeNode UpsideDownBinaryTree(TreeNode root) {
        TreeNode node = root, parent = null, left = null, right = null;
        while (node != null) {
            left = node.left;
            node.left = right;
            right = node.right;
            node.right = parent;
            parent = node;
            node = left;
        }
        return parent;
 }
