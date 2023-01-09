/*
Binary Search Tree(BST) implementation.
This BSTtree.java file includes:
- Build BST given a random array
- Insert
- Delete 
- Search existence of a value in the BST
- Print ordered array (in-order traversal)
- Find the medium value in the tree
*/

public class BSTtree extends BinTree {

        public BSTtree() {
            super();
        }

        public BSTtree(int i) {
            super(i);
        }
       
        public static BSTtree insert(BSTtree t, int val) {
            if (t == null){
                t = new BSTtree(val);
                return t;
            }

            if (val < ((BSTtree)t).value)
                    t.left = insert((BSTtree)t.left, val);
            else if (val > t.value)
                    t.right = insert((BSTtree)t.right, val);                            
            return t;
        }
       
        public static BSTtree BuildBSTtree(int a[]) {
            BSTtree root = new BSTtree(a[0]);
            for (int i = 1; i < a.length; i++) {
                root = insert(root, a[i]);
            }
            return root;
        }

        public static void OrderPrint(BSTtree t) {
            // in-order traversal of the BST tree gives ordered result
            if (t.left != null)
                OrderPrint((BSTtree)t.left);
            System.out.print(t.value + ", ");
            if (t.right != null)
                OrderPrint((BSTtree)t.right);
        }
       
        public static boolean exist(BSTtree t, int val){
            if(t==null)
                return false;
           
            if(t.value == val)
                return true;
           
            return ((val < t.value) ? exist((BSTtree)t.left, val)
                    : exist((BSTtree)t.right, val));
        }
    }
