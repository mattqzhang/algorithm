/*
Insert into a Cyclic Sorted List
All values in the linked list are sorted, and tail's next pointer is head. Given an array and we can build such an list.
If the root is starting from the minimum.
*/

/* Sorted cyclic list
 * All values in the linked list are sorted, and tail's next pointer is head
 * Root starting from the smallest value
 */

public class sortedCyclicList {

    // insert a value into the sorted cyclic list
    static myLinkedList insCyclic(myLinkedList root, int val) {
        if (root == null) {
            root = new myLinkedList();
            root.data = val;
            root.next = root; // make it cyclic
            return root;
        }

        myLinkedList cur = root;
        myLinkedList tail = root;
       
        // val is smallest, insert as new head
        if(cur.data >= val){             
            while(!cur.next.equals(root))
                cur = cur.next;
           
            //cur is now the tail
            myLinkedList newNode = new myLinkedList();
            newNode.data = val;
            newNode.next = root;
            cur.next = newNode;
            root = newNode;
            return root;
        }

        do {                      
            // val is between 2 values
            // insert after cur
            if (cur.data < val && cur.next.data >= val){
                myLinkedList newNode = new myLinkedList();
                newNode.data = val;
                newNode.next = cur.next;
                cur.next = newNode;
                return root;
            }
          
            tail = cur;
            cur = cur.next;
        }while (!cur.equals(root));

        // traverse the full list, and back to the root and still no find
        // it means it's the largest, and we need to insert it at the tail      
        myLinkedList newNode = new myLinkedList();
        newNode.data = val;
        newNode.next = root;
        tail.next = newNode;
       
        return root;
    }
   
    // Insert a value into the sorted cyclic list
    // A more compact solution, similar to the shifted case
    //    with an extra step to reset root
    static myLinkedList insCyclic_v2(myLinkedList root, int val) {
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
                    (cur.next.equals(cur))){                        // single node
                myLinkedList newNode = new myLinkedList();
                newNode.data = val;
                newNode.next = next;
                cur.next = newNode;
               
                // reset root if newNode is the min
                if(next.equals(root) && newNode.data <= next.data)
                    root = newNode;
               
                return root;
            }
          
            cur = next;
            next = cur.next;
        }while (!cur.equals(root));

        return root;
    }
   
    // build a sorted cyclic linked list
    static void makeCirList(int arr[]) {
        myLinkedList root = null;
       
        //make list version 1:
        for(int i=0; i<arr.length; i++)
            root = insCyclic(root, arr[i]);
        System.out.println("\nmake list: version 1: ");       
        printCyclicList(root);
       
        //make list version 2:
        root = null;
        for(int i=0; i<arr.length; i++)
            root = insCyclic_v2(root, arr[i]);
        System.out.println("\nmake list: version 2: ");
        printCyclicList(root);       
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
        makeCirList(arr);
    }

}

