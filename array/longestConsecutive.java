/*
Longest Consecutive Sequence

lc 128
https://leetcode.com/problems/longest-consecutive-sequence/description/
*/

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Arrays.sort(nums);
        int max = 1, cur = 1;

        for (int i=1; i<nums.length; i++) {
            if (nums[i] == nums[i-1] + 1) {
                cur++;
                if (cur > max) max = cur;
            } else if (nums[i] == nums[i-1]) {
                continue;
            } else {
                cur = 1;
            }
        }
        return max;   
    }
