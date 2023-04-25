/*
Contiguous Array
Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

lc 525
https://leetcode.com/problems/contiguous-array/description/
*/

    // take 0 as -1
    // if it contains same number of 0 and 1,
    //   then the sum would be same before and after
    public int findMaxLength(int[] nums) {
        int sum = 0;
        int max = 0;
        // <sum --> index> mapping
        // If multiple with same sum, then only record the 1st index
        //  the distance of indexes from the 1st of the same sum will be biggest.
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, -1);

        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 0)
                sum --;
            else
                sum ++;
            // 1st index with the sum
            if (!hm.containsKey(sum)) {
                hm.put(sum, i);
            } else {  // get an index with same sum
                int j = hm.get(sum);
                max = (i - j) > max ? i - j : max;
            }
        }
        return max;    
    }
