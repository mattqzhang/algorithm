/*
lc 416
https://leetcode.com/problems/partition-equal-subset-sum/
Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
*/

/**
 If elements can be divided into two equal groups, the sum of each group must be the half of sum. 
 So we just need to find a conbination which equals to the half of sum. 
 We can calculate the sum of the array. Then we define a boolean array for dynamic programming.
 
 For example, [1,2,4,5] ,sum = 12, half = 6.
 At beginning, if we find 6 exists in arrary, return true.
 Then we traversal the array. The first number is 1. 6 - 1 = 5, 
            if we find 6, 5 exist in array, return true.
 The next number is 2. 6 - 2 = 4, 5 - 2 = 3. If we find 6, 5, 4, 3 exist in array, we return true.
 The next number is 4, return true.
* */

public static boolean canPartition(int[] nums) {
    int len = nums.length;
    if (nums == null || len == 0)
        return false;

    int sum =0;
    for(int v : nums)
        sum += v;
    if (sum % 2 == 1)
        return false;

    int half = sum/2;
    // sum space from 0 to half
    // this is used to identify what we need to find, not what we arleady have
    boolean[] dp = new boolean[half + 1];
    // seed target for computation
    dp[half] = true;

    for(int i=0; i < len; i++){
        if(nums[i] > half)
            return false;
        // it’s the complement of some values checked earlier
        if(dp[nums[i]])
            return true;

        // for each num[i], check the values from num[i] to half,
        // if that value exists, mark the complement to be checked later.
        for(int val = nums[i]+1; val <= half; val++){
            // val is the target to be found
            if(dp[val])
                // mark the complement to be found
                dp[val - nums[i]] = true;
        }
    }
    return false;
}
