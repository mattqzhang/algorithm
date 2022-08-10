/*
lc 152
Maximum subarray Product
*/

public int maxProduct(int[] nums) {
    int max = nums[0], min = nums[0], res = nums[0];
    
    for(int i=1; i<nums.length; i++){
        int tmp = max;
        max = Math.max(Math.max(nums[i], nums[i] * max), nums[i] * min);
        // negative max
        min = Math.min(Math.min(nums[i], nums[i] * min), nums[i] * tmp);
        if(max > res)
            res = max;
    }
    return res;
}
