/*
Max Consecutive Ones
Given an array A of 0s and 1s, we may change up to K values from 0 to 1. Return the length of the longest (contiguous) subarray that contains only 1s. 
Use a window, move right first to contain at most K zeros, then move left

lc 1004
https://leetcode.com/problems/max-consecutive-ones-iii/

*/

public static int longestOnes(int[] A, int K) {
    int l = 0, r = 0;
    int ct_zero = 0;
    int sum = 0, max = 0;
    while (r < A.length) {
        while (r < A.length && (A[r] == 1 ||
                (A[r] == 0 && ct_zero < K))) {
            sum++;
            if (sum > max)
                max = sum;

            if (A[r] == 0) {
                ct_zero++;
            }
            r++;
        }
        if (r == A.length)
            return max;

        // now A[r] = 0 && ct_zero = K
        while (A[l] == 1) {
            l++;
            sum--;
        }
        // move pass 1st left zero
        l++;
        ct_zero --;
        sum --;
    }
    return max;
}
