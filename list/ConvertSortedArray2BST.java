/*
Given an integer array nums where the elements are sorted in ascending order, 
convert it to a height-balanced binary search tree.

lc 108:
https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
*/

class Solution {
    public TreeNode toBST(int[] nums, int start, int end) {
         if (start > end) return null;
         if (start == end)
             return new TreeNode(nums[start]);

         int mid = (start + end + 1) / 2;
         TreeNode left = toBST(nums, start, mid-1);
         TreeNode root = new TreeNode(nums[mid]);
         TreeNode right = toBST(nums, mid + 1, end);
         root.left = left;
         root.right = right;
         return root;
     }

    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        TreeNode root = toBST(nums, 0, n-1);
        return root;
    }
}
