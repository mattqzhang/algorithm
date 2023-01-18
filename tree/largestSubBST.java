/*
Find the largest subtree in a binary tree which is a BST.
Note that subtree must include all of its descendants.
*/

package Trees;

/* Find the largest subtree in a binary tree which is a BST.
 * subtree must include all of its descendants.
 *  */

// wrapper class including stats in the tree
// used to help the efficient algorithm
class WTreeStat {
    int min;    // local min in subtree
    int max;    // local max in subtree
    int maxSize;    // global max BST tree size
    BinTree lgBST;    // largest BST
}

public class largestSubBST {

    /***************** a simple recursive solution *************
     *  O(N^2)
     * */
    // aux function to check if the tree is BST
    static boolean isBST(BinTree root, int min, int max){
        if (root == null)      
            return true;
      
        if(root.value < min || root.value > max)
            return false;
      
        return (isBST(root.left, min, root.value) &&
                isBST(root.right, root.value, max));      
    }
 
    // aux function to get size of any subtree
    static int getSize(BinTree root, int ct){
        if(root == null)
            return ct;
      
        ct++;
        ct = getSize(root.left, ct);
        ct = getSize(root.right, ct);
        return ct;
    }
 
    // solution to find the largest SubTree BST
    // return the size of the subtree.
    static int findLgSubBST_simpl(BinTree root){
        int size = 0;
      
        if(isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE))
            return getSize(root, size);
      
        int n1 = findLgSubBST_simpl(root.left);
        int n2 = findLgSubBST_simpl(root.right);
        return(n1 > n2? n1 : n2);
      
    }
 
    /***************** a more efficient solution *************
     * Bottom up approach
     * O (N)
     * */
    static int findLgSubBST(BinTree tree, WTreeStat wt){
        if(tree == null)
            return 0;
      
        boolean isBST = true;
      
        int leftsize = findLgSubBST(tree.left, wt);        
        // current value should be bigger than the max value in left subtree
        if(leftsize == -1 || (leftsize != 0 && tree.value <= wt.max )) {
                isBST = false;
                return -1;
        }
              
        int rightsize = findLgSubBST(tree.right, wt);        
        // current value should be smaller than the min value in right subtree
        if(rightsize == -1 || (rightsize != 0 && tree.value >= wt.min )) {
                isBST = false;
                return -1;
        }
        
        // min value in current subtree is the min from left tree if it exists
        int curmin = (leftsize == 0) ? tree.value : wt.min;
        wt.min = curmin;
            
        // max value in current subtree is the max from right tree if it exists
        int curmax = (rightsize == 0) ? tree.value : wt.max;    
        wt.max = curmax;
         
        // update global solution
        int cursize = leftsize + rightsize + 1;
        if(cursize > wt.maxSize){
            wt.maxSize = cursize;
            wt.lgBST = tree;
        }
        return cursize;
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
        //BinTree.printTree_level(root);
       
        int size = findLgSubBST_simpl(root);
        System.out.println("\nsimple solution: " + size);
               
        WTreeStat wt = new WTreeStat();
        wt.min = Integer.MIN_VALUE;
        wt.max = Integer.MAX_VALUE;
        wt.maxSize = 0;
        wt.lgBST = null;
       
        findLgSubBST(root, wt);                
        System.out.println("efficient solution: " + wt.maxSize);
        System.out.println("largest BST subtree is : ");
        BinTree.printTree_level(wt.lgBST);
       
        System.out.println("\n\n************************* example 2 *****************");
        /* create tree
         *        50
         *      /    \
         *    30       20
         *   /  \
         *  15   40          
         */
        a = new int[]{50, 30, 20};
        root = BinTree.buildTree(a);
        root.left.left = new BinTree(15);
        root.left.right = new BinTree(40);
        //BinTree.printTree_level(root);
       
        size = findLgSubBST_simpl(root);
        System.out.println("simple solution: " + size);
               
        wt = new WTreeStat();
        wt.min = Integer.MIN_VALUE;
        wt.max = Integer.MAX_VALUE;
        wt.maxSize = 0;
        wt.lgBST = null;
       
        findLgSubBST(root, wt);                
        System.out.println("efficient solution: " + wt.maxSize);
        System.out.println("largest BST subtree is : ");
        BinTree.printTree_level(wt.lgBST);
       
    }   
}
