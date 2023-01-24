/*
Convert sorted linked list to BST
Recursive top down (nlogn): find the middle of the list to be the root, recursively convert left list to be left child, and right list to be right child.
Recursive bottom up(O(n)): The idea is to insert nodes in BST in the same order as they appear in Linked List so that the tree can be constructed in O(n) time complexity. We first count the number of nodes in the given Linked List. Let the count be n. After counting nodes, we take left n/2 nodes and recursively construct the left subtree. After left subtree is constructed, we allocate memory for root and link the left subtree with root. Finally, we recursively construct the right subtree and link it with root.
While constructing the BST, we also keep moving the list head pointer to next so that we have the appropriate pointer in each recursive call.
*/

/* An O(n) solution, build  tree bottom up
   refer to https://www.geeksforgeeks.org/sorted-linked-list-to-balanced-bst/
The idea is to insert nodes in BST in the same order as they appear in Linked List so that the tree can be constructed in O(n) time complexity. We first count the number of nodes in the given Linked List. Let the count be n. After counting nodes, we take left n/2 nodes and recursively construct the left subtree. After left subtree is constructed, we allocate memory for root and link the left subtree with root. Finally, we recursively construct the right subtree and link it with root. 
While constructing the BST, we also keep moving the list head pointer to next so that we have the appropriate pointer in each recursive call.
*/
class Solution {
    static ListNode head;

    int countNodes()  
    { 
        int count = 0; 
        ListNode temp = head; 
        while (temp != null) 
        { 
            temp = temp.next; 
            count++; 
        } 
        return count; 
    } 

    TreeNode sortedListToBSTRecur(int n)  
    { 
        /* Base Case */
        if (n <= 0)  
            return null; 
  
        /* Recursively construct the left subtree */
        TreeNode left = sortedListToBSTRecur(n / 2); 
  
        /* head_ref now refers to middle node,  
           make middle node as root of BST*/
        TreeNode root = new TreeNode(head.val); 
  
        // Set pointer to left subtree 
        root.left = left; 
  
        /* Change head pointer of Linked List for parent  
           recursive calls */
        head = head.next; 
  
        /* Recursively construct the right subtree and link it  
           with root. The number of nodes in right subtree  is  
           total nodes - nodes in left subtree - 1 (for root) */
        // NOTE: we cannot write it as n/2 - 1, due to rount down.
        root.right = sortedListToBSTRecur(n - n/2 - 1); 
  
        return root; 
    } 

    public TreeNode sortedListToBST(ListNode head) {
        /*Count the number of nodes in Linked List */
        this.head = head;
        int n = countNodes(); 
  
        /* Construct BST */
        return sortedListToBSTRecur(n); 
    }
}


/*
Recursive, O(nlogn)
*/

class Solution {
    public TreeNode convertList2Tree(ListNode head, ListNode tail){
        if (head == null) return null;
        if (head.val > tail.val) return null;
        if (head == tail) return new TreeNode(head.val);

        ListNode fast = head, slow = head, slowpre=null;

        while (fast != null && fast != tail) {
            slowpre = slow;
            slow = slow.next;
            fast = fast.next;
            if (fast != null && fast != tail)
                fast = fast.next;
        }
        TreeNode root = new TreeNode(slow.val);
        TreeNode left = convertList2Tree(head, slowpre);
        TreeNode right = convertList2Tree(slow.next, tail);
        root.left = left;
        root.right = right;
        return root;
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null; 
        ListNode tail = head;
        while (tail.next != null) tail = tail.next;
        return convertList2Tree(head, tail);
    }
}
