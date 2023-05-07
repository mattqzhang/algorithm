/*
House Robber
Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

lc 198
https://leetcode.com/problems/house-robber/description/
*/


// solution 1: solve optimal at each postion, record global max

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int dp[] = new int[n];
        dp[0] = nums[0];
        dp[1] = nums[1];

        int max = Math.max(dp[0], dp[1]);
        for (int i=2; i<n; i++) {
            dp[i] = nums[i];
            for (int j=0; j<i-1; j++) {
                dp[i] = Math.max(nums[i] + dp[j], dp[i]);
                max = (dp[i] > max) ? dp[i] : max;
            }
        }
        return max;
    }



// solution 2: get optimal for each step

    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                dp[i] = nums[i];
            } else if ( i == 1) {
                dp[i] = Math.max(dp[0], nums[1]);
            } else {
                dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
            }
        }
        return dp[len-1];
    }
