/*
Convert sorted linked list to BST
Recursive top down (nlogn): find the middle of the list to be the root, recursively convert left list to be left child, and right list to be right child.
Recursive bottom up(O(n)): The idea is to insert nodes in BST in the same order as they appear in Linked List so that the tree can be constructed in O(n) time complexity. We first count the number of nodes in the given Linked List. Let the count be n. After counting nodes, we take left n/2 nodes and recursively construct the left subtree. After left subtree is constructed, we allocate memory for root and link the left subtree with root. Finally, we recursively construct the right subtree and link it with root.
While constructing the BST, we also keep moving the list head pointer to next so that we have the appropriate pointer in each recursive call.
*/

/*
Recursive, O(nlogn)
* */
public static ListNode getMiddle(ListNode head, ListNode tail){
    ListNode one = head, two = head;
    while(true){
        one = one.next;
        two = two.next;
        if(two == tail)
            break;
        else two = two.next;
        if(two == tail)
            break;
    }
    return one;
}

public static TreeNode convertList2Tree(ListNode head, ListNode tail){
    if(head == null && tail == null)
        return null;

    if(head == null)
        return new TreeNode(tail);
    if(tail == null)
        return new TreeNode(head);

    if(head == tail)
        return new TreeNode(head);

    ListNode midNode = getMiddle(head, tail);
    TreeNode root = new TreeNode(midNode);
    TreeNode leftChild = convertList2Tree(head, midNode.pre);
    TreeNode rightChild = convertList2Tree(midNode.next, tail);
    root.left = leftChild;
    root.right = rightChild;
    return root;
}
