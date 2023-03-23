/*
First Missing Positive
Given an unsorted integer array nums, return the smallest missing positive integer.
You must implement an algorithm that runs in O(n) time and uses constant extra space.

lc 41
https://leetcode.com/problems/first-missing-positive/description/
*/

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int i = 0;
        while (i<n) {
            int a = nums[i];
            if (a > 0 && a < n) {
                if (nums[a-1] != a) {
                    // move a to the nums[a-1] position
                    // don't i+1 here as we may need to do it recursively
                    nums[i] = nums[a - 1];
                    nums[a - 1] = a;
                } else {
                    i++;
                }
            } else {
                i++;
            }
        }
        // find the first unmatched one
        for (i=0; i<n; i++) {
            if (nums[i] != i+1)
                return i+1;
        }
        // all match, return the next one after n
        return n+1;
    }
