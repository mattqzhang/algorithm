/* BFS, DFS, in-oder, pre-order, post-order:  */

List<Integer> list = new LinkedList<>();

public List<Integer> inorderTraversal(TreeNode root) {
    if(root == null)
        return list;

    inorderTraversal(root.left);
    list.add(root.val);
    inorderTraversal(root.right);
    return list;
}

/*
 * Traverse a Binary Tree
 *
 * Author: Qing "Matt" Zhang
 * https://sites.google.com/site/mattzhangcube/home/coding
 */

import java.util.*;

public class treeTraverse{

    //Depth First Search.
    //In this example it's just pre-order traversal
    public static void dfs(BinTree tree){
        if(tree == null)
            return;
        System.out.print(tree.value + " ");
        dfs(tree.left);
        dfs(tree.right);
    }
   
    //Breath First Search
    public static void bfs(BinTree tree){
        if(tree == null)
            return;
       
        Queue<BinTree> qe = new LinkedList<BinTree>();       
        qe.add(tree);
        while(!qe.isEmpty()){
            BinTree node = qe.remove();
            System.out.print(node.value + " ");
            if(node.left != null)
                qe.add(node.left);
            if(node.right != null)
                qe.add(node.right);
        }                   
    }
   
    public static void inOrder(BinTree tree){
        if(tree == null)
            return;
        inOrder(tree.left);
        System.out.print(tree.value + " ");
        inOrder(tree.right);
    }


    // non-recursive in-order (dfs) on a binary tree
    public static List<TreeNode> inOrder_nonRec(TreeNode root){
        List<TreeNode> res = new LinkedList<>();
        if(root == null)
            return res;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(true) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else if (!stack.isEmpty()) {
                cur = stack.pop();
                res.add(cur);
                cur = cur.right;
            } else
                break;
        }
        return res;
    }
 
 
    public static void postOrder(BinTree tree){
        if(tree == null)
            return;
        postOrder(tree.left);       
        postOrder(tree.right);
        System.out.print(tree.value + " ");
    }
   
    public static void main(String args[]) {       
        int a[] = { 5, 2, 6, 9, 3, 11, 1, 4, 8, 7, 10, 12 };

        //build a random binary tree, put values in level by level
        BinTree tree = BinTree.buildTree(a);
        System.out.println("old tree:");
        BinTree.printTree_level(tree);
       
        System.out.println("\n\nDFS search the tree:");       
        dfs(tree);
       
        System.out.println("\n\nBFS search the tree:");       
        bfs(tree);
       
        System.out.println("\n\nIn-order traversal the tree:");       
        inOrder(tree);
       
        System.out.println("\n\nPost-Order traversal the tree:");       
        postOrder(tree);
    }
}
