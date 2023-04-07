/*
Minimize Maximum of Array

lc 2439
https://leetcode.com/problems/minimize-maximum-of-array/description/
*/

    public int minimizeArrayValue(int[] nums) {
        if (nums.length == 0) return 0;

        // need long type, as we are computing sum for lots of ints
        long max = nums[0], sum = nums[0];

        for (int i=1; i<nums.length; i++) {
            sum += nums[i];
            long avg = (long) Math.ceil((double)sum/(i+1));
            // max cannot decrease
            max = Math.max(max, avg);
        }
        return (int)max;
    }
