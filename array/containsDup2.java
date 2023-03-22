/*
Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

lc 219
https://leetcode.com/problems/contains-duplicate-ii/
*/

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            int v = nums[i];
            if (hm.containsKey(v)) {
                int idx = hm.get(v);
                if (i - idx <= k)
                    return true;
            }
            hm.put(v, i);
        }
        return false;
    }
