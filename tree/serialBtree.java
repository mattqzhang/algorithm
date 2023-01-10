/*
Serialize a general Binary Tree to file, and de-Serialize it back from a file to the original Binary tree.
We can do this by BFS: when exploring each node, write it's two children to file. For the null child, use '$' to represent.
When reading back, read two lines at a time, as we already have the '$' representation for null child.
*/

* Serial a Binary Tree to a file, and read back exactly the same tree.
 *
 * When writing:
 * BFS traverse the tree.
 * Starting from the root, save the left/right child to file.
 * - if it's null, use a "$" to represent it.
 * - if it's not null, push it into bfs queue for further exploration.
 *
 *  When reading:
 *  - read 1st line and construct root, push into queue
 *  - for each element in queue, read two lines, which will be left/right child of this element:
 *    > if the line is '$', the corresponding child is null
 *    > if a valid value, put as the corresponding child, and push into queue for further construction
 * */

import java.io.*;
import java.util.*;

public class serialBtree {

    /* Serial a Binary Tree to a file:
     */
    static void serialBTree(BinTree root, String filename){
        if(root == null)
            return;
       
        try {           
            FileWriter fw = new FileWriter(filename);
            BufferedWriter bw = new BufferedWriter(fw);
            // calls the actual pre-order write function
            //writeBST(root, bw);   
           
            // BFS order to write the nodes
            // put '$' for Null child
            Queue<BinTree> qe = new LinkedList<BinTree>();
           
            qe.add(root);
            bw.write(Integer.toString(root.value));
            bw.newLine();
           
            BinTree node;
            while(!qe.isEmpty()){
                node = qe.remove();                               
               
                if(node.left != null){
                    qe.add(node.left);
                    bw.write(Integer.toString(node.left.value));
                    bw.newLine();
                }else{
                    bw.write('$');
                    bw.newLine();
                }
               
                if(node.right != null){
                    qe.add(node.right);
                    bw.write(Integer.toString(node.right.value));
                    bw.newLine();
                }else{
                    bw.write('$');
                    bw.newLine();
                }
            }
                           
            bw.close();
        } catch (IOException ex) {
            System.out.println("Error writing to file '" + filename + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
    }
   
    static BinTree deSerialBTree(String filename){
        BinTree root = null;
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            String line;
            
            line = br.readLine();
            if(line == "$"){
                br.close();
                return root;    // null tree
            }
                        
            int val = Integer.parseInt(line);           
            root = new BinTree(val);         
            
            Queue<BinTree> qe = new LinkedList<BinTree>();
            qe.add(root);
            BinTree node;
            
            //while((line = br.readLine()) != null) {
            while(!qe.isEmpty()){  
                node = qe.remove();    // current parent node
               
                // left child
                line = br.readLine();
                if(line == null){
                    br.close();
                    throw new Exception("bad file format");
                }
               
                if(line.equals("$")){
                    node.left = null;
                }else{
                    BinTree newnode = new BinTree(Integer.parseInt(line));
                    node.left = newnode;
                    qe.add(newnode);
                }
               
                // right child
                line = br.readLine();
                if(line == null){                          
                    br.close();
                    throw new Exception("bad file format");
                }
               
                if(line.equals("$")){
                    node.right = null;
                }else{
                    BinTree newnode = new BinTree(Integer.parseInt(line));
                    node.right = newnode;
                    qe.add(newnode);
                }
            }
                       
            // when all nodes in queue are done, we should also be at end of file
            if((line = br.readLine()) != null){
                br.close();
                throw new Exception("bad file format");
            }
               
            br.close();
            
        }catch (Exception e){
            e.getMessage();
        }
       
        return root;
    }


    static final int a[] = { 5, 2, 6, 9, 3, 11, 1, 4, 8, 7, 10, 12 };
   
    public static void main(String[] args) {
   
        String filename = "btree.txt";
        BinTree root = BinTree.buildTree(a);
        System.out.println("original tree:");
        BinTree.printTree_level(root);
       
        System.out.println("\nserializing ... ");
        serialBTree(root, filename);
       
        System.out.println("\nd-serializing ... ");
        BinTree readRoot = deSerialBTree(filename);
        BinTree.printTree_level(readRoot);

        /**** 2nd test: apply it to the BST ****/
        System.out.println("\n\n******* bst tree test *******");
        
        filename = "bsttree.txt";
        BSTtree bstroot = BSTtree.BuildBSTtree(a);
        System.out.println("original bst tree:");
        BinTree.printTree_level(bstroot);
        
        System.out.println("\nserializing ... ");
        serialBTree(bstroot, filename);
        
        System.out.println("\nde-serialized tree: ");
        BinTree readbstRoot = deSerialBTree(filename);
        BinTree.printTree_level(readbstRoot);
        
    }

}

