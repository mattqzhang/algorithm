/* Count total number of nodes in tree/count leaf nodes */

package com.com.tree.mz;

public class countNodes {

    /* count total number of nodes in the tree
     * any traversal can do this. Here use a simple pre-order */
    public static int count_total(BinTree tree, int ct){
        if (tree==null)
            return ct;

        ct ++;
        ct = count_total(tree.left, ct);
        ct = count_total(tree.right, ct);

        return ct;
    }

    // another solution:
    static int countNodes(BinTree root) {
        if (root == null)
            return 0;

        int count = 1;
        count += countNodes(root.left);
        count += countNodes(root.right);
        return count;
    }

    /* count num of leaf nodes in the tree
     * only increase count when it's leaf node during traversal */
    public static int count_leaf(BinTree tree, int ct){
        if(tree == null)
            return ct;

        if((tree.left == null) && (tree.right == null))
            ct++;
        else{
            ct = count_leaf(tree.left, ct);
            ct = count_leaf(tree.right, ct);
        }

        return ct;
    }

    // another count leaf
    static int countLeaf(BinTree root){
        if (root == null)
            return 0;

        if(root.left == null && root.right == null)
            return 1;

        return countLeaf(root.left) + countLeaf(root.right);
    }

    public static void main(String[] args) {
        int a[] = { 5, 2, 6, 9, 3, 11, 1, 4, 8, 7, 10, 12 };
        //build a random binary tree, put values in level by level
        BinTree tree = BinTree.buildTree(a);

        System.out.println("old tree:");
        BinTree.printTree_level(tree);

        System.out.println("\ntotal num of nodes: " + count_total(tree, 0));
        System.out.println("\ntotal num of nodes v2: " + countNodes(tree));

        System.out.println("num of leaf nodes: " + count_leaf(tree, 0));
        System.out.println("num of leaf nodes v2: " + countLeaf(tree));
    }

}
