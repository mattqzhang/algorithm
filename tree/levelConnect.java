/*
Level Connection: Given a binary tree, assume each node has an extra pointer, let it point to the next node in the same level.That is, connect all nodes in the same level.
*/

/* Given a binary tree, assume each node has an extra pointer,
 * let it point to the next node in the same level.
 * That is, connect all nodes in the same level.
 * */

class BNode{
    BNode left;        //left child
    BNode right;    //right child
    BNode next;        //next node in the same level
}

public class levelConnect {

    public static void connect(BNode root){
        if(root == null)
            return;
       
        if(root.left != null)
            root.left.next = root.right;
       
        if(root.right != null)
            if(root.next != null)
                root.right.next = root.next.left;
       
        connect(root.left);
        connect(root.right);
    }

    //for a sparse tree, we need to use while(root->next has left or right child) to find the next one to link to
}

