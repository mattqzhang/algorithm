/*
Longest ZigZag Path in a Binary Tree

lc 1372
https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/description/
*/

class Solution {
    int max;

    void longest(TreeNode root, boolean goLeft, int step) {                
        if (root == null) return;
        if (max < step) max = step;

        if (goLeft) {
            longest(root.left, false, step + 1);
            longest(root.right, true, 1);
        } else {  // go right
            longest(root.right, true, step +1);
            longest(root.left, false, 1) ; 
        }
    }

    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;
        max = 0;
        longest(root, true, 0);
        longest(root, false, 0);

        return max;
    }
}

// my similar solution

class Solution {
    int max;

    // direction: left = true, right = false;
    void longest(TreeNode root, boolean fromLeft, int step) {
        if (root == null) return;
        if (max < step)
            max = step;

        if (fromLeft) {
            longest(root.right, false, step + 1);
            longest(root.left, true, 1);
        } else {  // from right
            longest(root.left, true, step +1);
            longest(root.right, false, 1) ;
        }
    }
    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;
        max = 0;
        longest(root.left, true, 1);
        longest(root.right, false, 1);

        return max;
    }
}
