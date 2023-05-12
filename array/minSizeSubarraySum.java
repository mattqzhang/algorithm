/*
Minimum Size Subarray Sum
Given an array of positive integers nums and a positive integer target, return the minimal length of a 
subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

lc 209
https://leetcode.com/problems/minimum-size-subarray-sum/description/
*/

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0, min = Integer.MAX_VALUE;
        int sum = nums[0];

        // two pointers, keep the window as small as possible
        while (right < nums.length) {
            if ( sum < target) {
                right ++;
                if (right < nums.length)
                    sum += nums[right];
            } else {  // sum >= t
                if (right - left + 1 < min)
                    min = right - left + 1;
                sum -= nums[left];
                left++;
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
