/*
lc 42
https://leetcode.com/problems/trapping-rain-water/

Trapping Rain Water
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
*/

public int trap(int[] height) {
    int n = height.length;
    if(n == 0)
        return 0;

    int res = 0;
    int[] leftMax = new int[n];
    int[] rightMax = new int[n];

    leftMax[0] = height[0];
    for(int i=1; i<n; i++)
        // max height from the left till i
        leftMax[i] = Math.max(leftMax[i-1], height[i]);

    rightMax[n-1] = height[n-1];
    for(int i=n-2; i>=0; i--)
        // max height from the right till i
        rightMax[i] = Math.max(rightMax[i+1], height[i]);

    for(int i=1; i<n-1; i++)
        res += Math.min(leftMax[i], rightMax[i]) - height[i];

    return res;
}
