/*
Convert a BST tree to a doubly linked list (void)
We can recursively create the list for the left tree and right tree, then link them together.
*/

/* transform a BST to a doubly linked list */

// doubly LL
class DoubleLL{
    int val;
    DoubleLL pre;
    DoubleLL next;
}


public class BST2DoubleLL {

    // attached the 2nd double LL to the end of the 1st LL.
    // head of new list is still the 1st head
    static DoubleLL attach(DoubleLL first, DoubleLL second){
        if(first == null)
            return second;
       
        if(second == null)
            return first;
       
        DoubleLL flast = first.pre;        //last node in the 1st list
        DoubleLL slast = second.pre;    // last node in the 2nd list
       
        // attach head of 2nd to tail of 1st
        flast.next = second;
        second.pre = flast;
        // link tail of 2nd back to head of 1st
        slast.next = first;
        first.pre = slast;
       
        return first;
    }
   
    /* recrusively build the list */
    static DoubleLL BST2DLL_rec(BSTtree root){
        if(root == null)
            return null;
       
        // create a new node acocrding to the root, which is self linked
        DoubleLL cur = new DoubleLL();       
        cur.val = root.value;
        cur.pre = cur;
        cur.next = cur;
       
        // small is the head of the list from left subtree
        DoubleLL small = BST2DLL_rec((BSTtree)root.left);
        // large is the head of the list from right subtree
        DoubleLL large = BST2DLL_rec((BSTtree)root.right);
       
        // attach current node to end of small list       
        small = attach(small, cur);
       
        // attach large list to the end of the new small list
        small = attach(small, large);
       
        // small is the head of the combined list
        return small;
    }
   
    static void print_dll(DoubleLL head){
        if(head == null)
            return;
        System.out.print(head.val + ", ");
       
        DoubleLL cur = head.next;
        while(cur != head){
            System.out.print(cur.val + ", ");
            cur = cur.next;
        }
    }
   
    public static void main(String[] args) {
        int a[] = { 5, 2, 6, 9, 3, 11, 1, 4, 8, 7, 10, 12 };
        BSTtree root = BSTtree.BuildBSTtree(a);
        System.out.println("original BST tree:");
        BinTree.printTree_level(root);
       
        System.out.println("\n double list content: ");
        DoubleLL dbll = BST2DLL_rec(root);
        print_dll(dbll);
       
    }

}

