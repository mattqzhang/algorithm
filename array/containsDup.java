/*
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

lc 217
https://leetcode.com/problems/contains-duplicate/description/
*/

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for (int v : nums) {
            if (hs.contains(v)) return true;
            hs.add(v);
        }
        return false;
    }
