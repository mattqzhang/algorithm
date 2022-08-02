/*
Range Sum Query - 1D
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
There are many calls to sumRange function.
*/


private int[] sum;

public RangeSum(int[] nums){
    sum = new int[nums.length + 1];
    sum[0] = 0;
    for(int i=0; i<nums.length; i++)
        sum[i+1] = sum[i] + nums[i];
}

public int sumRange(int i, int j) {
    return (sum[j+1] - sum[i]);
}

