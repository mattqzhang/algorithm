/*
Max Path Sum through the Root
Given a tree, write a function to return the sum of the max-sum path which goes through the root node.
*/

// find max path sum from a node to the leaf
int maxChildSum(Node node){
    if (node == null)
        return 0;

    // ignore if < 0
    int leftSum = Math.max(maxChildSum(node.left), 0);
    int rightSum = Math.max(maxChildSum(node.right), 0);

    int sum = Math.max(leftSum, rightSum);
    sum += node.val;
    return sum;
}

int maxSum(Node root){
    if(root == null)
        return 0;
    // get left and right path sum, then add root
    int leftSum = maxChildSum(root.left);
    int rightSum = maxChildSum(root.right);
    return root.val + leftSum + rightSum;
}
