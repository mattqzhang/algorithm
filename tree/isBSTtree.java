/*
Check if a binary tree is a BST
We can do it recursively, and passing the min/max value in each sub tree.
We can also use an in order traversal to find out.
*/

public class isBSTtree {
    
public boolean validHelper(TreeNode root, Integer lower, Integer upper) {
    if(root==null)
        return true;

    if(lower != null && root.val <= lower) return false;
    if(upper != null && root.val >= upper) return false;

    if(! validHelper(root.left, lower, root.val)) return false;
    if(! validHelper(root.right, root.val, upper)) return false;

    return true;
}

public boolean isValidBST(TreeNode root) {
    return validHelper(root, null, null);
}

    /*  Using in-order traversal
     *  Since in-order traversal should have a sorted output,
     *  each value should be bigger than the previous value.
     */

    // keep a record of the previously visited node.
    static BinTree prev = null;
   
    static boolean isBST(BinTree root){
        if(root == null)
            return true;
       
        if(!isBST(root.left))
            return false;
                                       
        if(prev!= null && root.value < prev.value )
            return false;
   
        prev = root;
        return isBST(root.right);
       
    }   
   
    /* recursive algorithm */
    // keep the max and min in current subtree
    static boolean isBST_rec(BinTree root, int min, int max){
        if (root == null)       
            return true;                 
       
        return (root.value > min &&
                root.value < max &&
                isBST_rec(root.left, min, root.value) &&
                isBST_rec(root.right, root.value, max));       
    }
   
    public static void main(String[] args) {
        /*  BST
         *             15
         *           /   \
         *        8        17
         *        /  \
         *     6   12
         */
        int a1[] = {15, 8, 17, 6, 12};       
        BinTree root = BinTree.buildTree(a1);
        System.out.println("a1 is BST: " + isBST(root));       
        System.out.println("a1 is BST: " + isBST_rec(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
        /*  not BST
         *             15
         *           /   \
         *        8        17
         *        /  \
         *     6   16
         */
        int a2[] = {15, 8, 17, 6, 16};
        root = BinTree.buildTree(a2);
        System.out.println("a2 is BST: " + isBST(root));
        System.out.println("a1 is BST: " + isBST_rec(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }
}

