/*
Convert a Binary tree to a doubly linked list.
We can recursively create the list for the left tree and right tree, then link them together. Do it in place.
*/

   Node first = null;
   Node last = null;

   public void inoder(Node root){
       if(root == null)
           return;

       inoder(root.left);
       if(last != null) {
           last.right = root;
           root.left = last;
       }else
           first = root;
       last = root;

       inoder(root.right);
   }

public Node treeToDoublyList(Node root) {
    if(root == null)
        return null;
    inoder(root);
    last.right = first;
    first.left = last;
    return first;
}

// another solution:

    Node bintree2listUtil(Node node) 
    {
        // Base case
        if (node == null)
            return node;
  
        // Convert the left subtree and link to root
        if (node.left != null) 
        {
            // Convert the left subtree
            Node left = bintree2listUtil(node.left);
  
            // Find inorder predecessor. After this loop, left
            // will point to the inorder predecessor
            for (; left.right != null; left = left.right);
  
            // Make root as next of the predecessor
            left.right = node;
  
            // Make predecssor as previous of root
            node.left = left;
        }
  
        // Convert the right subtree and link to root
        if (node.right != null) 
        {
            // Convert the right subtree
            Node right = bintree2listUtil(node.right);
  
            // Find inorder successor. After this loop, right
            // will point to the inorder successor
            for (; right.left != null; right = right.left);
  
            // Make root as previous of successor
            right.left = node;
  
            // Make successor as next of root
            node.right = right;
        }
  
        // trace to the head of the list and return
        while(node.left != null) {
            node = node.left;
        }
        return node;
    }

