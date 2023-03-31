/*
Restore a Binary Tree given the in-order and pre-order traversal list
The root is the 1st element in the pre-order list, and divides the left and right tree in the in-order list.
We can use this property to solve this problem recursively.

lc 105
https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
*/

    // always find next root using preOrder
    int preOrderIndex;
    // inorder node index
    Map<Integer, Integer> hm = new HashMap<>();

    TreeNode buildRec(int[] preorder, int start, int end) {
        // start and end controls the size of each subtree,
        // and decides when to stop recursion here
        if (start > end) return null;

        int rootVal = preorder[preOrderIndex];
        TreeNode root = new TreeNode(rootVal);

        preOrderIndex++;
        root.left = buildRec(preorder, start, hm.get(rootVal) - 1);
        root.right = buildRec(preorder, hm.get(rootVal) +1, end);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        if (preorder.length == 1) return new TreeNode(preorder[0]);

        preOrderIndex = 0;
        // value to index mapping, in the inorder array
        for (int i=0; i<inorder.length; i++) {
            hm.put(inorder[i], i);
        }
        return buildRec(preorder, 0, preorder.length-1);
    }


        public static void main(String[] args) {
        test1 obj=new test1();

        System.out.println("\ndone");
    }


// a little more complicate solution, same idea:

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
