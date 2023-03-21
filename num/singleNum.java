/*
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
You must implement a solution with a linear runtime complexity and use only constant extra space.

lc 136
https://leetcode.com/problems/single-number/
*/

    public int singleNumber(int[] nums) {
        int res = nums[0];
        for (int i=1; i< nums.length; i++) {
            res ^= nums[i];
        }
        return res;        
    }

