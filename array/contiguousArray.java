/*
Contiguous Array
Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

lc 525
https://leetcode.com/problems/contiguous-array/description/
*/

    // take 0 as -1
    // if it contains same number of 0 and 1,
    //   then the sum would be same before and after
    // compute the aggreated sum at each index and save in hashmap
    public static int findMaxLength(int[] nums) {
        int sum  = 0;
        int max = 0;
        // <sum, index>
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, -1);

        for (int i=0; i<nums.length; i++) {
            sum += (nums[i] == 0) ? -1 : 1;
            if (hm.containsKey(sum)) {
                max = Math.max(max, i - hm.get(sum));
            } else {
                // only save the first index of this sum to get max length
                hm.put(sum, i);
            }
        }

        return max;
    }
