/*
Convert a sorted array to a Balanced BST
Choose the middle value as the root, then recursively convert left and right parts as subtrees. O(N).
*/

/* Convert a sorted array to a Balanced BST */

public class sortArray2BST {

    // recursive solution, root is the mid of the array
    static BSTtree arr2BST(int a[], int start, int end){
        if(start > end)
            return null;
       
        int mid = (start + end)/2;
        BSTtree root = new BSTtree(a[mid]);
        root.left = arr2BST(a, start, mid-1);
        root.right = arr2BST(a, mid+1, end);
        return root;
    }

    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4, 5, 6, 7};
        BSTtree root = arr2BST(a, 0, a.length-1);
        System.out.println("tree by level: ");
        BinTree.printTree_level(root);
       
        System.out.println("\n ordered output");
        BSTtree.OrderPrint(root);
    }

}

