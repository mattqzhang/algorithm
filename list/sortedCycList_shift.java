/*
Insert into a Cyclic Sorted List
All values in the linked list are sorted, and tail's next pointer is head. Given an array and we can build such an list.
If root can be any value in the list (shifted sorted list)
*/

public Node insert(Node head, int insertVal) {
    if(head == null){
        Node ins = new Node(insertVal);
        ins.next = ins;
        return ins;
    }

    Node headCopy = head;
    //smaller, need to go to end of circle, then trace back
    if(insertVal <= head.val) {
        // head.next cannot be null, as it's circular link
        while (head.next != headCopy && head.val <= head.next.val)
            head = head.next;

        // head is now the biggest value;
        // next is the smallest value;

        // it's the smallest val
        if(insertVal <= head.next.val){
            Node ins = new Node(insertVal);
            ins.next = head.next;
            head.next = ins;
            return headCopy;
        }
        // move head to smallest val
        head = head.next;
    }

    // now search in the increasing circle, till the biggest one
    Node next = head.next;
    while (insertVal >= next.val && head.val <= head.next.val  && head.next != headCopy) {
        head = next;
        next = next.next;
    }
    Node ins = new Node(insertVal);
    ins.next = head.next;
    head.next = ins;

    return headCopy;
}

/* Sorted cyclic list
 * All values in the linked list are sorted, and tail's next pointer is head
 * Root can be any value in the list (shifted list after sorted)
 */

public class sortedCycList_shift {

    // insert a value into the sorted cyclic list
    static myLinkedList insShift(myLinkedList root, int val) {
        if (root == null) {
            root = new myLinkedList();
            root.data = val;
            root.next = root; // make it cyclic
            return root;
        }

        myLinkedList cur = root;
        myLinkedList next = cur.next;
       
        do {                                  
            // insert after cur
            if ((cur.data <= val && cur.next.data >= val) ||        // val is between 2 values
                    (cur.data > next.data && val >= cur.data) ||    // val is max
                    (cur.data > next.data && val <= next.data) ||    // val is min
                    (root.next.equals(root))){                        // single node
                myLinkedList newNode = new myLinkedList();
                newNode.data = val;
                newNode.next = next;
                cur.next = newNode;
                return root;
            }
          
            cur = next;
            next = cur.next;
        }while (!cur.equals(root));

        return root;
    }

    // build a sorted cyclic linked list
    static myLinkedList makeCirList(int arr[]) {
        myLinkedList root = null;
        for(int i=0; i<arr.length; i++)
            root = insShift(root, arr[i]);
       
        return root;
    }

    // print the cyclic list
    static void printCyclicList(myLinkedList root) {
        myLinkedList cur = root;
        if(cur == null)
            return;
       
        System.out.print(cur.data + " ");
        cur = cur.next;
       
        while(!cur.equals(root)){
            System.out.print(cur.data + " ");
            cur = cur.next;           
        }
    }

    // test case
   
    public static void main(String[] args) {
        // no duplicate
        //int arr[] = { 5, 2, 6, 9, 3, 11, 1, 4, 8, 7, 10, 12 };
        // has duplicate
        int arr[] = { 5, 2, 6, 1, 9, 3, 11, 1, 5, 3, 12, 4, 8, 7, 10, 12};
        myLinkedList root = makeCirList(arr);
        printCyclicList(root);
    }

}

