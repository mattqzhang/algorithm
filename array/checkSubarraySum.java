/*
lc 523

Continuous Subarray Sum
Given a list of non-negative numbers and a target integer k, write a function to check if the array has a continuous subarray of size at least 2 that sums up to a multiple of k, that is, sums up to n*k where n is also an integer.
Use pre-computed sum array, or hashmap, to compare the remainders. 
*/

// Solution 1: use  cumulative sum array
public boolean checkSubarraySum(int[] nums, int k) {
    int[] sum = new int[nums.length + 1];
    sum[0] = 0;
    for(int i=1; i <= nums.length; i++){
        sum[i] = sum[i-1] + nums[i-1];
    }

    for(int i=0; i<nums.length; i++){
        for(int j=i+1; j<nums.length; j++){
            int cur_sum = sum[j+1] - sum[i];
            if(cur_sum == k || (k!=0 && cur_sum % k == 0))
                return true;
        }
    }
    return false;
}

// Solution 2: store the remainder map
public boolean checkSubarraySum(int[] nums, int k) {
    int sum = 0;
    //<remainder, index> mapping
    HashMap < Integer, Integer > map = new HashMap < > ();
    map.put(0, -1);
    for (int i = 0; i < nums.length; i++) {
        sum += nums[i];
        if (k != 0)
            sum = sum % k;

        if (map.containsKey(sum)) {
            //get a new one with same remainder
            if (i - map.get(sum) > 1)
                return true;
        } else
            map.put(sum, i);
    }
    return false;
}
