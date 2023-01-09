/*
Same value count in BST: Given a Binary Search Tree and a key value, find the number of nodes having this key.
*/

static int countSame(BSTtree root, int key, int count){
    if(root == null)
        return 0;

    if (root.value == key){
        count = 1 + countSame((BSTtree)root.left, key, count)
                + countSame((BSTtree)root.right, key, count);
    }else if(root.value < key) // only right tree can have it
        count += countSame((BSTtree)root.right, key, count);
    else //(root.value > max)   // only left tree can be in range
        count += countSame((BSTtree)root.left, key, count);
    return count;
}
