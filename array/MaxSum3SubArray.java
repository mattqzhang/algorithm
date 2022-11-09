/*
lc 689
https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays/

Maximum Sum of 3 Non-Overlapping Subarrays
In a given array nums of positive integers, find three non-overlapping subarrays with maximum sum.
Each subarray will be of size k, and we want to maximize the sum of all 3*k entries.
Return the result as a list of indices representing the starting position of each interval (0-indexed). If there are multiple answers, return the lexicographically smallest one.
*/

public int[] maxSumOfThreeSubarrays(int[] nums, int K) {
    //pre-compute W as the array of all sums of windows with size K, from 0 to n-K+1;
    // W[i]: sum from i to i + (K - 1)
    int[] W = new int[nums.length - K + 1];
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
        sum += nums[i];
        if (i >= K)
            // compute sum at end idx
            sum -= nums[i-K];
        if (i >= K-1)
            // save the sum at start idx
            W[i-K+1] = sum;
    }

    // precompute the best start point on the left of i
    int[] left = new int[W.length];
    int best = 0;
    for (int i = 0; i < W.length; i++) {
        if (W[i] > W[best])
            best = i;
        left[i] = best;
    }

    // best start point on the right of i
    int[] right = new int[W.length];
    best = W.length - 1;
    for (int i = W.length - 1; i >= 0; i--) {
        // "=" for smallest idx
        if (W[i] >= W[best])
            best = i;
        right[i] = best;
    }

    int[] ans = new int[]{-1, -1, -1};
    // for each middle j, the best on the left and right are already precomputed
    for (int j = K; j < W.length - K; j++) {
        int i = left[j - K], k = right[j + K];
        
        if (ans[0] == -1 || W[i] + W[j] + W[k] >
                W[ans[0]] + W[ans[1]] + W[ans[2]]) {
            ans[0] = i;
            ans[1] = j;
            ans[2] = k;
        }
    }
    return ans;
}
