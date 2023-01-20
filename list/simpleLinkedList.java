/*
Basic Linked List Implementation
- add node to front
- add node to tail
- get length of list
- build list from a given array
- print out values in the list sequentially
*/

/* base linked list definition */

class myLinkedList{
    int data;
    myLinkedList next;
}

/*
 *  An auxiliary class which contains the commonly used routines for linked list
 * */
public class simpleLinkedList {
   
    // add a node to the front of the list
    public myLinkedList addFront(myLinkedList head, myLinkedList node){
        node.next = head.next;
        head = node;
        return head;
    }
   
    //add a node to the tail of the list
    public void addTail(myLinkedList head, myLinkedList node){
        myLinkedList tail = head;
        while(tail.next !=null )
            tail = tail.next;
        tail.next = node;       
    }
   
    // get the lenghth of the list
    public int getLength(myLinkedList head){
        myLinkedList cur = head;
       
        int len = 0;
        while(cur != null){
            len ++;
            cur = cur.next;
        }
        return len;           
    }
   
    //given an array, build LL directly
    public myLinkedList buildList(int arr[]){
        if(arr.length == 0)
            return null;
       
        myLinkedList head = new myLinkedList();
        head.data = arr[0];
        Node cur = head;
       
        for(int i=1; i<arr.length; i++){
            myLinkedList newNode = new myLinkedList();
            newNode.data = arr[i];
            cur.next = newNode;
            cur = newNode;
        }
       
        return head;
    }

    //print values in list in order
    public void printList(myLinkedList head){
        myLinkedList cur = head;
        while(cur != null){
            System.out.print(cur.data + ", ");           
            cur = cur.next;
        }
    }
}
