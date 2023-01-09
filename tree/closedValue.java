/*
Closed BSTValue
Given a non-empty binary search tree and a floating point target value, find the value in the BST that is closest to the target.

lc 270
https://leetcode.com/problems/closest-binary-search-tree-value/
*/

/**
 * BST tree search
 */
public int closestValue(TreeNode root, double target) {
    double prediff = Math.abs(root.val - target);
    double diff = 0;
    int result = root.val;

    while(root != null) {
        if(root.left != null && target <= root.val)
            root = root.left;
        else if(root.right != null && target >= root.val)
            root = root.right;
        else
            root = null;

        if(root != null) {
            diff = Math.abs(root.val - target);
            if (diff < prediff) {
                prediff = diff;
                result = root.val;
            }
        }
    }
    return result;
}

/**
* Create an in-order traversal of the tree first, then search
* */
void inOrder(LinkedList<Integer> num, TreeNode root){
    if(root == null)
        return;
    inOrder(num, root.left);
    num.add(root.val);
    inOrder(num, root.right);
}

public int closestValue_v2(TreeNode root, double target) {
    LinkedList<Integer> nums = new LinkedList<Integer>();
    inOrder(nums, root);
    if(nums.size() <= 1)
        return root.val;

    double prediff = Long.MAX_VALUE;
    int res = -1;
    for(int i=0; i<nums.size(); i++){
        int cur = nums.get(i);
        double diff = Math.abs(target - cur);
        if(diff < prediff) {
            res = cur;
            prediff = diff;
        }else
            return res;
    }
    return res;
}
