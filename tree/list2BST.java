/*
Convert a sorted linked list to a Balanced BST
1. We can copy the list to an array, then apply above array algorithm. O(N).
2. We can do it similarly as the array algorithm, find the middle point of each sublist. Need to search through the list every time, so O(N^2).
3. We do it bottom up, do it in "left tree-> parent -> right tree" order. O(N)
*/

/* Convert a sorted linked list to Balanced BST
 * Construct the tree in a bottom-up way, do it in "left tree-> parent -> right tree" order.
 * We can do it in O(N) time.
 * */

// sorted linked list
class sLinkedList{
    int val;
    sLinkedList next;
    sLinkedList(int v){
        val = v;
        next = null;
    }   
}

// wrapper class to pass the linked list around functions
class WList{
    sLinkedList list;
}

public class list2BST {

    /* create the nodes bottom up, */
    static BSTtree LL2BST(WList wlist, int start, int end){
        if(start > end)
            return null;
       
        // find the middle idx, and recursively do left/right child tree
        int mid = (start + end )/2;
        BSTtree leftchild = LL2BST(wlist, start, mid-1);
       
        // after finish all nodes in the left subtree in order,
        // assign the current one as parent.
        BSTtree parent = new BSTtree(wlist.list.val);
        parent.left = leftchild;
       
        // Next construct the right subtree, which is after the current parent in the list.
        // Increase the current list position,
        //    which will now be the 1st node of the right subtree
        // (note: we don't need to do this for left subtree, as the current list position
        //     is always the smallest index, and is assigned to the left tree.
        //    so we only need to do it for right trees.)
        wlist.list = wlist.list.next;
        parent.right = LL2BST(wlist, mid+1, end);
       
        return parent;
    }   
   
    // help function to print the list
    static void printList(sLinkedList list){
        System.out.println("\nPrinting the sorted linked list");
        while(list!= null){
            System.out.print(list.val + ", ");
            list = list.next;
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        int a[] = {0, 1, 2, 3, 4, 5, 6, 7, 8,9};
       
        //initialize the sorted linked list       
        sLinkedList slist = new sLinkedList(a[0]);
        sLinkedList tail = slist;
        for(int i=1; i<a.length; i++){
            tail.next = new sLinkedList(a[i]);
            tail = tail.next;
        }
        printList(slist);
   
        int len = a.length;       
        WList wlist = new WList();
        wlist.list = slist;
       
        BSTtree root = LL2BST(wlist, 0, len-1);
        BinTree.printTree_level(root);
    }
}

