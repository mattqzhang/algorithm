/*
Element product: 
Given an array A, output another array B such that B[k]=product of all elements in A but A[k]. You are not allowed to use division.
*/

public static int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] left = new int[n];
    int[] right = new int[n];
    int[] res = new int[n];

    left[0] = 1;
    right[n-1] = 1;
    for (int i=1; i<n; i++){
        left[i] = left[i-1] * nums[i-1];
        right[n-1-i] = right[n-i] * nums[n-i];
    }
    for(int i=0; i<n; i++)
        res[i] = left[i] * right[i];

    return res;
}
