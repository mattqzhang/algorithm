/*
Find the Difference of Two Arrays
Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:
    answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
    answer[1] is a list of all distinct integers in nums2 which are not present in nums1.


lc 2215
https://leetcode.com/problems/find-the-difference-of-two-arrays/description/
*/


    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> hs1 = new HashSet<>();
        for (int v : nums1) {
            hs1.add(v);
        }
        HashSet<Integer> hs2 = new HashSet<>();
        for (int v : nums2) {
            hs2.add(v);
        }

        List<Integer> unique1 = new LinkedList<>();
        List<Integer> unique2 = new LinkedList<>();

        for (int v : hs1) {
            if (hs2.contains(v)) {
                hs2.remove(v);
            } else {
                unique1.add(v);
            }
        }
        for (int v : hs2) {
            unique2.add(v);
        }
        List<List<Integer>> result = new LinkedList<>();
        result.add(unique1);
        result.add(unique2);
        return result;   
    }
