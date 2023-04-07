/*
Max Consecutive Ones
Given a binary array nums, return the maximum number of consecutive 1's in the array.

lc 485
https://leetcode.com/problems/max-consecutive-ones/description/
*/

    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums.length == 0)
            return 0;
        
        int ct = 0;
        int max = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 1) {
                ct++;
                if (ct > max) max = ct;
            } else {
                ct = 0;
            }
        }
        return max;        
    }
