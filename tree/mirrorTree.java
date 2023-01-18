/*
Tree Mirroring: Given a binary tree, return the mirror of this tree.
Do it recursively.
*/

/*
 * Given a binary tree, return the mirror of that tree
 *
 * Author: Qing "Matt" Zhang
 * https://sites.google.com/site/mattzhangcube/home/coding
 */

public class mirrorTree extends BinTree{

    //recursive method, changes the original tree.
    static BinTree makeMirror(BinTree tree){       
        if(tree == null)
            return null;
       
        BinTree tmpNode = tree.left;
        tree.left = makeMirror(tree.right);
        tree.right = makeMirror(tmpNode);
        return tree;
    }
   
    // keeps the original tree and clone a new one.
    // using bfs, for each node in tree, create a new node in newTree;
    static BinTree makeMirror_clone(BinTree tree){
        if(tree==null)
            return null;
       
        BinTree newTree = new BinTree();
        newTree.value = tree.value;
        newTree.right = makeMirror_clone(tree.left);
        newTree.left = makeMirror_clone(tree.right);
       
        return newTree;
    }
   
    public static void main(String[] args) {       
        int a[] = { 5, 2, 6, 9, 3, 11, 1, 4, 8, 7, 10, 12 };
        //mirrorTree extends BinTree, so we can call this directly.
        BinTree tree = buildTree(a);
        System.out.println("old tree:");
        printTree_level(tree);
       
        BinTree newTreeClone = makeMirror_clone(tree);
        System.out.println("\n\nold tree after clone:");
        printTree_level(tree);
        System.out.println("\nnew tree after clone:");
        printTree_level(newTreeClone);
       
        BinTree newTree = makeMirror(tree);
        System.out.println("\n\nnew tree after mirror:");
        printTree_level(newTree);               
        /* System.out.println("\nold tree after mirror:");
        printTree_level(tree); */
    }
}

