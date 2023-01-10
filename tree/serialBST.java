/*
Serialize a BST to file, and de-Serialize it back from a file to the original BST.
Best approach is to use pre-order traversal.
When reading back, use the same BST insertion algorithm.
*/

ackage Trees;

import java.io.*;

public class serialBST {

    /**** serialize a BST tree to a file ****/
    
    // recursively write the tree nodes, pre-order
    static void writeBST(BSTtree node, BufferedWriter bw) {
        if (node != null) {
            try {
                bw.write(Integer.toString(node.value));
                bw.newLine();
                writeBST((BSTtree)node.left, bw);
                writeBST((BSTtree)node.right, bw);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    // driver function
    static void serializeBST(BSTtree root, String fileName) {    
        try {            
            FileWriter fw = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(fw);
            // calls the actual pre-order write function
            writeBST(root, bw);    
            bw.close();
        } catch (IOException ex) {
            System.out.println("Error writing to file '" + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
    }
    
    /**** read back a BST tree from file ****/
    
    static BSTtree deSerialBST(String fileName){
        BSTtree root = null;
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line;
            line = br.readLine();
            int val = Integer.parseInt(line);
            
            root = new BSTtree(val);            
            while((line = br.readLine()) != null) {
                BSTtree.insert(root, Integer.parseInt(line));
            }
            
            br.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return root;
    }
    
    static final int a[] = { 5, 2, 6, 9, 3, 11, 1, 4, 8, 7, 10, 12 };
    public static void main(String[] args) {
        String fileName = "BSTtree.txt";
        BSTtree root = BSTtree.BuildBSTtree(a);
        System.out.println("original tree:");
        BinTree.printTree_level(root);
        
        System.out.println("\nserializing ... ");
        serializeBST(root, fileName);
        
        System.out.println("de-serialized tree: ");
        BSTtree readRoot = deSerialBST(fileName);
        BinTree.printTree_level(readRoot);
    }

}


