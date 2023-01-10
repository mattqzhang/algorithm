/*
We may easily extend the SerDeBT.java algorithm for general tree with arbitrary fanouts:
- when we write, for each node written to the file, we also write the number of children
- when reading back, if a node has k children, we read the next k lines.

We can also solve this problem by doing a pre-order traversal, and do it recursively.

we use '$' to represent a null node. If the value of the tree can be any character including '$', we may record each node's value followed by some flags indicating the existence of each children, and decode this when reading back.
*/

import java.io.*;
import java.util.*;

/* Serial a Binary Tree to a file, and read back exactly the same tree.
 * Using recursive algorithms
 */

public class serialBtree_rec {

    /* Serial a Binary Tree to a file.
     * Using preorder traversal
     */
    // recursive pre-order write function
    static void writeBtree_pre(BinTree node, BufferedWriter bw){
        try {
            if (node == null) {
                bw.write("$");
                bw.newLine();
            } else {
                bw.write(Integer.toString(node.value));
                bw.newLine();
                writeBtree_pre(node.left, bw);
                writeBtree_pre(node.right, bw);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    // serial write driver function
    static void serialBTree_pre(BinTree root, String filename){       
        try {           
            FileWriter fw = new FileWriter(filename);
            BufferedWriter bw = new BufferedWriter(fw);
           
            // calls the actual recursive pre-order write function
            writeBtree_pre(root, bw);   
            bw.close();
        } catch (Exception e) {
            e.getMessage();
        }
    }
   
   
    /**** read back the same tree from file, also recursive ****/
    // recursive read function
    static BinTree readBtree_pre(BufferedReader br){
        String line;
        BinTree node  = null;
        try {
            if ((line = br.readLine()) == null)
                return null;
           
            node = new BinTree(Integer.parseInt(line));
            node.left = readBtree_pre(br);
            node.right = readBtree_pre(br);           
        }catch(Exception e){
            e.getMessage();
        }       
        return node;
    }
   
    // serial read driver function
    static BinTree deSerialBTree_pre(String filename){
        BinTree root = null;
        try {           
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
           
            // calls the actual recursive pre-order write function
            root = readBtree_pre(br);   
            br.close();
        } catch (Exception e) {
            e.getMessage();
        }
        return root;
    }
   
    /****** test case **********/
    static final int a[] = { 5, 2, 6, 9, 3, 11, 1, 4, 8, 7, 10, 12 };
   
    public static void main(String[] args) {
        String filename = "btree_pre.txt";
       
        BinTree root = BinTree.buildTree(a);
        System.out.println("original tree:");
        BinTree.printTree_level(root);
      
        System.out.println("\nserializing ... ");
        serialBTree_pre(root, filename);
      
        System.out.println("\nd-serializing ... ");
        BinTree readRoot = deSerialBTree_pre(filename);
        BinTree.printTree_level(readRoot);

        /**** 2nd test: apply it to the BST ****/
        System.out.println("\n\n******* bst tree test *******");
       
        filename = "bsttree_pre.txt";
        BSTtree bstroot = BSTtree.BuildBSTtree(a);
        System.out.println("original bst tree:");
        BinTree.printTree_level(bstroot);
       
        System.out.println("\nserializing ... ");
        serialBTree_pre(bstroot, filename);
       
        System.out.println("\nde-serialized tree: ");
        BinTree readbstRoot = deSerialBTree_pre(filename);
        BinTree.printTree_level(readbstRoot);

    }

}

