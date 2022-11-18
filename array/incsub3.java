/*
lc 334
https://leetcode.com/problems/increasing-triplet-subsequence/

Increasing Triplet Subsequence
Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.
*/

public static boolean increasingTriplet(int[] nums) {
    int num1= Integer.MAX_VALUE;
    int num2= Integer.MAX_VALUE;
    for(int num : nums){
        // update 1st
        if(num<num1) {
            num1=num;
            continue;
        }
        // setup 2nd
        if(num>num1)
            num2=Math.min(num2,num);
        // num is different than num2, this must be num3
        if(num>num2)
            return true;
    }
    return false;
}
