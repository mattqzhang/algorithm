/*
Rotate Array
Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

lc 189
https://leetcode.com/problems/rotate-array/description/
*/


// O(1), in place reverse:

    void reverse(int[] nums, int s, int e) {
        while (s < e) {
            int tmp = nums[s];
            nums[s++] = nums[e];
            nums[e--] = tmp;
        }
    }
    
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        
        // reverse all
        reverse(nums, 0, n-1);
        // reverse first k
        reverse(nums, 0, k-1);
        // reverse remaining
        reverse(nums, k, n-1);
    }



// simple solution: copy last k into tmp array

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        int tmp[] = new int[n];        
        for (int i = 0; i< k; i++) {
            tmp[i] = nums[n-k + i];
        }
        for (int i=k; i<n; i++) {
            tmp[i] = nums[i-k];
        }
        for (int i=0; i<n; i++)
            nums[i] = tmp[i];
    }
