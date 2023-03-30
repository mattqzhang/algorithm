/*
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

lc 75
https://leetcode.com/problems/sort-colors/description/
*/

   // if we're allowed to use sorting algorithms, counting sort is the simplest.
   // otherwise do the in-place swap, and scan the array only once.
 
    public void sortColors(int[] nums) {
        if (nums.length == 0) return;

        int front = 0;
        while(front < nums.length && nums[front] == 0) {
            front ++;
        }
        -- front; // last 0

        int end = nums.length - 1;
        while(end >= 0 && nums[end] == 2) {
            end --;
        }
        ++ end;  // first 2

        int i = front + 1;
        while(i < end) {
            if (nums[i] == 0 && i != front) {
                swap(nums, i, ++front);
            } else if (nums[i] == 2 && i != end) {
                swap(nums, i, --end);
            } else
                i++;
        }
    }
