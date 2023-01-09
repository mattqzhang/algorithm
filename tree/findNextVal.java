/* Given a Binary Search Tree and a key value,
 * find the next bigger value for this key.
 */
public class findNextVal {

    static int findNext(BSTtree root, int key){
        assert(root != null);
        // return max value if it's the largest value
        int result = Integer.MAX_VALUE;
           
        BSTtree cur = root;
        while(cur != null){
            if(key >= cur.value){
                //the next bigger value would be in the right subtree
                cur = (BSTtree)cur.right;           
            }else{
                // key will be in left tree.
                // the current value might be the answer, save it.
                result = cur.value;
                cur = (BSTtree)cur.left;               
            }
        }
       
        return result;
    }

    static final int a[] = { 5, 2, 6, 9, 3, 11, 1, 4, 8, 7, 10, 12 };
   
    public static void main(String[] args) {
       
        BSTtree root = BSTtree.BuildBSTtree(a);
        System.out.println("the tree output by level");      
        BinTree.printTree_level(root);
       
        int key = 5;
        System.out.println("\nnext value is " + findNext(root, key));    
    }
}
