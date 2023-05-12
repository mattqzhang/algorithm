/*
Remove Duplicates from Sorted Array
Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.

lc 26
https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
*/

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int left = 0;
        for (int i=1; i<n; i++) {
            // find a new value, move to the left
            if (nums[i] != nums[i-1]) {
                nums[++left] = nums[i];
            }
        }
        return left + 1;  
    }


    // another solution, work backwords
    public int removeDuplicates(int[] nums) {
        int idx = nums.length-1;
        while (idx > 0 && nums[idx] == nums[idx-1]) {
            idx--;
        }
        
        for (int i = idx; i > 0; i--) {
            if (nums[i] == nums[i-1]) {
                // move i and later values forward one position
                for (int j = i; j < nums.length-1; j++)
                    nums[j] = nums[j+1];
                idx--;
            }
        }
        return idx+1;
    }
