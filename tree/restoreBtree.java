/*
Restore a Binary Tree given the in-order and pre-order traversal list
The root is the 1st element in the pre-order list, and divides the left and right tree in the in-order list.
We can use this property to solve this problem recursively.
*/

import java.util.*;
/* Restree a binary tree, from the in-order and pre-order traversal lists
 *
 * Solve this problem recursively:
 * - the 1st element in the pre-order list is the root
 * - find the index of the root in the in-order list
 *         > it divides the left and right tree in the in-order list
 *         > we can also find the size of the left/right tree
 *  - in the pre-order list,
 *      > left tree is the lsize elements following the root
 *      > right tree is the remaining elements after the left tree
 *  - we can then extract the left/right tree elements from both lists,
 *    and recursively solves this problem.
 * */
public class restoreBtree {

    static HashMap<Integer, Integer> idxInOrder = new HashMap<Integer, Integer>();

    // recursive method to build the tree
    static BinTree restore(int ino[], int in_s, int in_e,
                           int pre[], int pre_s, int pre_e){                                       
        if(in_e < in_s)
            return null;
      
        // 1st element in pre-order tree is the root
        BinTree node = null;       
        int val = pre[pre_s];
        node = new BinTree(val);
      
        // use in-order list to split the child trees for recursion
        // root index in the in-order list
        int idx = idxInOrder.get(val);
        // everything to the left is the left tree
        int lsize = idx - in_s;             
       
        // recursively solves the left/right sublists.
        node.left = restore(ino, in_s, in_s+lsize-1,
                pre, pre_s+1, pre_s+lsize);
       
        node.right = restore(ino, idx+1, in_e,
                pre, pre_s+lsize+1, pre_e);
      
        return node;
    }
      
    public static void main(String[] args) {
        int preorder[] = {7,10,4,3,1,2,8,11};
        int inorder[] = {4,10,3,1,7,11,8,2};

        // initialize hashmap for inorder array
        for(int i=0; i<inorder.length; i++){
            idxInOrder.put(inorder[i], i);
        }
      
        int n = inorder.length;
        BinTree root = restore(inorder, 0, n-1, preorder, 0, n-1);
        BinTree.printTree_level(root);
    }
}
