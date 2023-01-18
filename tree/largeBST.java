/*
Find the largest BST in a binary tree
The largest BST may or may not include all of its descendants.
*/

/*Given a binary tree, find the largest Binary Search Tree (BST),
 * where largest means BST with largest number of nodes in it.
 * The largest BST may or may not include all of its descendants.
 */


// wrapper class passing around the statistics
class WrapperStat{
    int size;
    int maxsize;    // global max size of BST so far
    BinTree lgRoot;    // global root for max BST
    BinTree child;    //
}

public class largeBST {
         
    static int lgBST(BinTree cur, int min, int max, WrapperStat ws){
        if(cur == null)
            return 0;
       
        // current node extends the BST
        if(cur.value > min && cur.value < max){
            int leftsize = lgBST(cur.left, min, cur.value, ws);
            BinTree leftChild = (leftsize == 0 ? null : ws.child);
           
            int rightsize = lgBST(cur.right, cur.value, max, ws);
            BinTree rightChild = (rightsize == 0? null : ws.child);
           
            // clone the current node, attached left/right child
            // and make it the new child for its parent node.
            BinTree bst = new BinTree(cur.value);
            bst.left = leftChild;
            bst.right = rightChild;
           
            ws.child = bst;
            int size = leftsize + rightsize + 1;
            if(size > ws.maxsize){
                ws.maxsize = size;
                ws.lgRoot = bst;
            }
           
            return size;                       
        }
        // treat this as a new tree, and if there's solution in its subtree       
        else{
            lgBST(cur, Integer.MIN_VALUE, Integer.MAX_VALUE, ws);
            return 0;
        }       
    }

    public static void main(String[] args) {
        /* create tree
         *        50
         *      /    \
         *    30       60
         *   /  \     /  \
         *  5   20   45    70
         *                /  \
         *              65    80          
         */
        int a[] = {50, 30, 60, 5, 20, 45, 70};
        BinTree root = BinTree.buildTree(a);
        root.right.right.left = new BinTree(65);
        root.right.right.right = new BinTree(80);   
       
        WrapperStat ws = new WrapperStat();
        ws.size = 0;
        ws.maxsize = 0;
        ws.lgRoot = null;
        ws.child = null;
       
        int size = lgBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE, ws);
        System.out.println("size of largest BST is: " + size);
        BinTree.printTree_level(ws.lgRoot);
    }   
}

