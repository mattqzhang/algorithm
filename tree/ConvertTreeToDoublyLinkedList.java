/*
Convert BST to doubly linked list
*/

public static BSTtree CovertTreeToDoublyLinkedList(BSTtree node)
{
    if(node.left != null)
    {   // head node of left subtree
        BSTtree temp = CovertTreeToDoublyLinkedList((BSTtree)node.left);
        // go to the tail, and connect with current node
        while(temp.right != null) {
            temp = (BSTtree)temp.right;
        }
        temp.right = node;
        node.left = temp;
    }
    if(node.right != null)
    {   // head of the right subtree
        BSTtree temp = CovertTreeToDoublyLinkedList((BSTtree)node.right);
        // connect directly
        node.right = temp;
        temp.left = node;
    }
    // return head of the whole list
    while(node.left != null)
    {
        node = (BSTtree)node.left;
    }
    return node;
}

// return head and tail of the doublely linked list
Node[] rec(Node root){  
  Node[] leftList = new Node[]{root, root};
  if(root.left != null){
    leftList = rec(root.left);
    // append root to leftList
    root.left = leftList[1];
    leftList[1].right = root;
    // make root to be the tail
    leftList[1] = root;
  }

  if(root.right != null){
    Node[] rightList = rec(node.right);
    root.right = rightList[0];
    rightList[0].left = root;

    // copy right tail value to output tail
    leftList[1] = rightList[1];
  }

  return leftList;
}

