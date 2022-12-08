/*
Binary Tree implementation.
This BinTree.java file includes:
- Build a random tree from array,
- Print tree level by level
- Print the nodes on the exterior of a binary tree in a anti-clockwise order, i.e., nodes on left edge, then leaf nodes, then nodes on right edge.
- print height of tree
- print nodes at a certain level
*/

package com.com.tree.mz;

/*
 * Base class for Binary Tree
 * Author: Qing "Matt" Zhang
 * https://sites.google.com/site/mattzhangcube/home/coding
 */

import java.util.*;

class NodeInfo {
    BinTree node;
    int ht;

    NodeInfo(BinTree r, int height) {
        node = r;
        ht = height;
    }
}

public class BinTree {
    protected int value;
    protected BinTree left;
    protected BinTree right;

    public BinTree() {
    }

    public BinTree(int i) {
        value = i;
        left = null;
        right = null;
    }

    // print tree level by level
    // NOTE: if we're not allowed to use ht as shown here, then after we put root into queue,
    // we can add a '$' to queue, as the line terminator
    // every time we pop the '$' from queue, we add it back to the tail of the queue, to indicate another line.
    // put $ back only when queue is not empty.

    public static void printTree_level(BinTree root) {
        Queue<NodeInfo> qe = new LinkedList<NodeInfo>();

        NodeInfo rootInfo = new NodeInfo(root, 0);
        qe.add(rootInfo);
        int curht = 0;

        while (!qe.isEmpty()) {
            // print current node
            NodeInfo currentNode = qe.remove();
            int ht = currentNode.ht;
            // start a new level
            if (ht > curht) {
                curht = ht;
                System.out.println("");
            }
            System.out.print(currentNode.node.value + " ");

            // push children into queue
            if (currentNode.node.left != null) {
                NodeInfo newOne = new NodeInfo(currentNode.node.left, curht + 1);
                qe.add(newOne);
            }
            if (currentNode.node.right != null) {
                NodeInfo newOne = new NodeInfo(currentNode.node.right,
                        curht + 1);
                qe.add(newOne);
            }
        }
    }

    // print height of a tree
    public static int getHeight(BinTree root){
        if(root == null)
            return 0;

        int lh = getHeight(root.left);
        int rh = getHeight(root.right);
        return lh > rh ? (lh + 1) : (rh + 1);
    }

    /* Print nodes at a given level */
    static void printGivenLevel(BinTree root, int level)
    {
        if (root == null)
            return;
        if (level == 0)
            System.out.print(root.value + ", ");
        else if (level > 0)
        {
            printGivenLevel(root.left, level-1);
            printGivenLevel(root.right, level-1);
        }
    }

    // build a random tree, put values in the tree sequentially
    public static BinTree buildTree(int a[]) {
        BinTree root = new BinTree(a[0]);
        Queue<BinTree> qe = new LinkedList<BinTree>();
        qe.add(root);

        for(int i=1; i<a.length; i++){
            BinTree node = qe.remove();
            //add left child
            BinTree child = new BinTree(a[i]);
            node.left = child;
            qe.add(child);
            //add right child
            if(i<a.length-1){
                child = new BinTree(a[++i]);
                node.right = child;
                qe.add(child);
            }
        }
        return root;
    }

    // print out leaf nodes, from left to right
    // use in-order traversal
    public static void printLeaf(BinTree tree){
        if(tree == null)
            return;

        if(tree.left==null && tree.right ==null){
            System.out.print(tree.value + " ");
            return;
        }

        printLeaf(tree.left);
        printLeaf(tree.right);
    }

    //Print the nodes on the exterior of a binary tree in a anti-clockwise order,
    //i.e., nodes on left edge, then leaf nodes, then nodes on right edge.
    public static void printExterior(BinTree root){
        if(root == null)
            return;

        BinTree node = root;
        // left nodes, simply go through left child from root;
        // omit the left leaf as it's printed by the next func.
        while(node.left != null){
            System.out.print(node.value + " ");
            node = node.left;
        }

        //leaves, in-oder traversal and print only leaves.
        printLeaf(root);

        //right nodes, go through right child from root and push into stack,
        //then pop and print. Omit root and right leaf as they're already printed above
        Stack<BinTree> stk = new Stack<BinTree>();
        node = root.right;
        while(node.right != null){  //not right leaf
            stk.push(node);
            node = node.right;
        }
        // right corner node might not be a leaf node, so not printed yet.
        if(node.left != null)
            stk.push(node);

        while(!stk.isEmpty()){
            System.out.print(stk.pop().value + " ");
        }
    }

    public static void main(String[] args) {
        //int a[] = { 5, 2, 6, 9, 3, 11, 1, 4, 8, 7, 10, 12 };
        int a[] = { 5, 2, 6, 9, 3, 11, 1, 4, 8, 7};
        //mirrorTree extends BinTree, so we can call this directly.
        BinTree tree = buildTree(a);
        System.out.println("old tree:");
        printTree_level(tree);

        System.out.println("\n");
        System.out.println("print level 2:");
        printGivenLevel(tree, 2);

        System.out.println("\n\nexterior:");
        BinTree.printExterior(tree);
    }
}
