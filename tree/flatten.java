/*
lc 114
https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/

Flatten a tree into a list

Given a binary tree, flatten it to a linked list in-place.

Example :
Given


         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:

   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
Note that the left child of all nodes should be NULL.
*/

// recursive solution

    public void flatten(TreeNode root) {
        if (root == null) return;
        if (root.left == null) {
            flatten(root.right);
            return;
        }
        
        flatten(root.left);
        flatten(root.right);
        
        TreeNode leftEnd = root.left;
        while (leftEnd.right != null)
            leftEnd = leftEnd.right;
        
        TreeNode tmp = root.right;
        root.right = root.left;
        leftEnd.right = tmp;
        root.left = null;     
    }


// non-recursive

void flatten(Node root){ 

   if(root == null)
      return;

   Node node = root;
   while(node !=null) {
        // Attatches the right sub-tree to the rightmost leaf of the left sub-tree:
        if (node.left != null) {
            Node rightMost = node.left;
            while (rightMost.right != null) {
                rightMost = rightMost.right;
            }
            rightMost.right = node.right;

            // Makes the left sub-tree to the right sub-tree:
            node.right = node.left;
            node.left = NULL;
        }

        // Flatten the rest of the tree:
        node = node.right;
    }     
}

