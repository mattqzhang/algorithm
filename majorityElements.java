/*
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.


lc 169
https://leetcode.com/problems/majority-element/description/
*/

    public int majorityElement(int[] nums) {
        int total = nums.length;
        
        HashMap<Integer, Integer> hm = new HashMap();
        for (int v : nums) {
            int ct = hm.getOrDefault(v, 0) + 1;
            if (ct > total/2) 
                return v;
            hm.put(v, ct);
        }
        return 0;
    }
