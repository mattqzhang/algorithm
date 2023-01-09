/*
 * Iterator design for BST
 */

import java.util.*;

/* Iterator for BST */
class BSTIterator implements Iterator<Integer>{
    BSTtree root, current;
    Stack<BSTtree> nodeStack;
   
    public BSTIterator (BSTtree t){
        root = t;
        current = t;
        nodeStack = new Stack<BSTtree> ();
    }

    public boolean hasNext()
    {
        return (!nodeStack.empty() || current != null);
    }

    public Integer next()
    {
        Integer nextNodeValue;
       
        // push all left nodes into stack       
        while (current != null)
        {
            nodeStack.push(current);
            current = (BSTtree)current.left;
        }
       
        // top of stack is the leftmost node       
        current = nodeStack.pop();
        nextNodeValue = current.value;
        // move to the next right child, or null
        current = (BSTtree)current.right;
        return nextNodeValue;
    }
   
    public void remove(){
       
    }
}

/* Test */
public class BstIter {
   
    static final int a[] = { 5, 2, 6, 9, 3, 11, 1, 4, 8, 7, 10, 12 };

    public static void main(String args[]) {       

        BSTtree root = BSTtree.BuildBSTtree(a);
        System.out.println("the tree output by level");       
        BinTree.printTree_level(root);
       
        //System.out.println("\n\nthe ordered output");       
        //root.OrderPrint(root);
        System.out.println("\n\nIterator output");
        BSTIterator bstIter = new BSTIterator(root);
        while(bstIter.hasNext()){
            System.out.print(bstIter.next() + " ");
        }   
    }

}

