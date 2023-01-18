/*
Tree Rotation
Left and right rotate a binary tree
*/

/*
 * Left and Right rotate a binary tree
 *
 * Author: Qing "Matt" Zhang
 * https://sites.google.com/site/mattzhangcube/home/coding
 */

class Tree{
    Node root;
}

class Node{
    int val;
    Node left;
    Node right;
    Node parent;
}


/*
                  Y                                                                         X
               |        |              === right  rotate ===>                |        |
          X             C                                                           A         Y
        |      |                      <=== left rotate ===                            |    |
      A       B                                                                             B      C
*/

public class rotateTree {
   
    public void right_rotate(Tree T, Node y){
        Node x = y.left;
           
        if(x == null)
            return;
       
        /* move x's right child to be y's left */
        y.left = x.right;
        if(y.left != null)
            y.left.parent = y;

        /* setup y's parent */
        x.parent = y.parent;
        if(y.parent == null)
            T.root = x;
        else{
            if(x.parent.left == y)
                x.parent.left = x;
            else
                x.parent.right = x;           
        }
       
        /* move y to x's right child */
        x.right = y;
        y.parent = x;       
    }   
   
    public void left_rotate(Tree T, Node x){
        Node y = x.right;
       
        if(y == null)
            return;
       
        /* Move y's left child to be x's right child */
        x.right = y.left;
        if(x.right != null)
            x.right.parent = x;
       
        /* update y's parent */
        y.parent = x.parent;
        if (y.parent == null )
            T.root = x;
        else{
            if(y.parent.left == x)
                y.parent.left = y;
            else
                y.parent.right = y;
        }
       
        /* put x as y's left child */
        y.left = x;
        x.parent = y;       
    }
}
