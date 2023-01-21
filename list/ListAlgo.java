/*
How to find if there exist a cycle in a linked list?
Use 2 pointers, one moves 1 step each time, and another moves 2 steps. If 2nd catches first, then exists cycle.

Two singly linked list merged at some point. Find the point they merge.
Solution 1:
Reverse both lists, then traverse from the new head can compare, the reverse them back
Solution 2:
Get the length of the lists as L1 and L2 (suppose L1 > L2), and let H = L1 - L2. Move list 1 H steps, then move both lists together till they meet
Solution 3:
Scan and hash the nodes in the 1st list. Scan and hash node from 2nd list, till found.

How to decide if two linked lists merge?
All above solutions work. And there's a simple solution for this decision version:
Go to the tail of both lists. If they're the same, then return true.
*/

public class ListAlog {
   
    /* check if a list contains a cycle
     * Use two pointers from beginning, one move 1 step at a time,
     * and another move 2 steps. If the 2nd catches first, then
     * there exists a cycle, return true
     * */
    static boolean isCycle(myLinkedList head){
        myLinkedList p1, p2;
        p1 = p2 = head;
        while(p2 != null){
            p1 = p1.next;
            p2 = p2.next;
            if(p2 !=null )
                p2 = p2.next;
            if(p1 == p2)
                return true;
        }
        return false;
    }

    /* two single linked list, and they merge at some point.
     * find the point they merge */
    static myLinkedList findMerge(myLinkedList list1, myLinkedList list2){
        simpleLinkedList LL = new simpleLinkedList();
        int len1 = LL.getLength(list1);
        int len2 = LL.getLength(list2);
        myLinkedList cur1 = list1;
        myLinkedList cur2 = list2;
       
        if(len1 > len2){
            int h = len1 - len2;
            while(h>0){
                cur1 = cur1.next;
                h--;
            }
        }else{
            int h = len2 - len1;
            while(h>0){
                cur2 = cur2.next;
                h--;
            }
        }
        while(cur1 != null && cur2!=null){
            if(cur1 == cur2)
                return cur1;
           
            cur1 = cur1.next;
            cur2 = cur2.next;           
        }
        return null;
    }
}

