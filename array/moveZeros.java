/*
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

lc 283
https://leetcode.com/problems/move-zeroes/description/
*/

    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int slow = 0;
        // move slow to the first 0:
        while (slow < n && nums[slow] != 0) slow++;
        if (slow == n-1) return;
        
        // move fast to first non-zero after slow
        int fast = slow;
        while (fast < n && nums[fast] == 0) fast++;
        
        // swap fast/slow, and move forward to next pair
        while (fast < n) {
           int tmp = nums[slow];
           nums[slow] = nums[fast];
           nums[fast] = tmp;
           slow++;
           while (slow < n&& nums[slow] !=0) slow++;
           fast ++;
            while (fast < n && nums[fast] == 0) fast++;
        }        
    }
