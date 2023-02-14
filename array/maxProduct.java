/*
lc 152
Maximum subarray Product
*/

public int maxProduct(int[] nums) {
    // note that if nums[i] is negative, then maxProduct may be multiply with preivous negative min
    // so we need to record the min too. 
    int max = nums[0], min = nums[0], res = nums[0];

    for(int i=1; i<nums.length; i++){
        int tmp = max;
        max = Math.max(Math.max(nums[i], nums[i] * max), nums[i] * min);
        // min might be negative max
        min = Math.min(Math.min(nums[i], nums[i] * min), nums[i] * tmp);
        if(max > res)
            res = max;
    }
    return res;
}

