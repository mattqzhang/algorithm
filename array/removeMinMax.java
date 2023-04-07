/*
Removing Minimum and Maximum From Array
You are given a 0-indexed array of distinct integers nums.

There is an element in nums that has the lowest value and an element that has the highest value. We call them the minimum and maximum respectively. Your goal is to remove both these elements from the array.

A deletion is defined as either removing an element from the front of the array or removing an element from the back of the array.

Return the minimum number of deletions it would take to remove both the minimum and maximum element from the array.

lc 2091
https://leetcode.com/problems/removing-minimum-and-maximum-from-array/description/
*/

    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        if (n <=2 ) return n;

        int minIdx = 0, maxIdx = 0;
        for (int i=0; i<n; i++) {
            if (nums[i] < nums[minIdx]) minIdx = i;
            if (nums[i] > nums[maxIdx]) maxIdx = i;
        }

        // remove both from left
        int removeFromLeft = Math.max(minIdx, maxIdx) + 1;
        // remove both from right
        int removeFromRight = Math.max(n-minIdx, n-maxIdx);
        // remove one from left, and one from right
        int removeFromBoth = Math.min(minIdx, maxIdx) + 1 + Math.min(n-minIdx, n-maxIdx);

        // result the min of the above 3 choices
        return Math.min(removeFromLeft, Math.min(removeFromRight, removeFromBoth));
    }
