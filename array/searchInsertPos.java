/*
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
You must write an algorithm with O(log n) runtime complexity.

lc 35
https://leetcode.com/problems/search-insert-position/description/
*/

    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int begin = 0, end = n-1;
        while (begin <= end) {
            int mid = (begin + end)/2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] > target) {
                end = mid - 1;
            } else { // nums[mid] < target
                begin = mid + 1;
            }
        }
        // now begin > end
        return begin;
    }
