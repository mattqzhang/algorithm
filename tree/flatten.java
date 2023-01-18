/*
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

// recursive solution
void flattenNode_rec(Node node){
  if(node == null || node.left == null){
     return;
  }else{
    flattenNode(node.right);
    flattenNode(node.left);

    Node temp = node.left;
    while(temp.right != null){
      temp = temp.right;
    } 
    temp.right = node.right;
    node.right = node.left;
    node.left = null;
  }
}
