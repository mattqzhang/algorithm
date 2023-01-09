/*
Count values in a range in BST: Given a BST, and a range, find the number of nodes in this range.
*/

static int countRange(BSTtree root, int min, int max, int count){
    if(root == null)
        return 0;

    if (root.value > min && root.value < max){
        count = 1 + countRange((BSTtree)root.left, min, max, count)
                + countRange((BSTtree)root.right, min, max, count);
    }else if(root.value < min) // only right tree can be in range
        count += countRange((BSTtree)root.right, min, max, count);
    else //(root.value > max)   // only left tree can be in range
        count += countRange((BSTtree)root.left, min, max, count);
    return count;
}
