/*
Permutations II
Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

lc 47
https://leetcode.com/problems/permutations-ii/description/
*/

class Solution {
    List<List<Integer>> res;
    // value -> count
    HashMap<Integer, Integer> ctMap;
    int total;
    public void swap(int nums[], int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new LinkedList<>();
        ctMap = new HashMap<>();
        total = nums.length;
        // get the count of each val, no need to sort
        for (int i=0; i<nums.length; i++) {
            int ct = ctMap.getOrDefault(nums[i], 0);
            ctMap.put(nums[i], ++ct);
        }
        LinkedList<Integer> list = new LinkedList<>();
        permute(list);
        return res;
    }

    private void permute(LinkedList<Integer> cur) {
        if (cur.size() == total) {
            // NOTE: we need to make a deep copy of cur here,
            // as the original cur will be recursively changed.
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        // add each step, try to add a different value to the current list
        for (Map.Entry<Integer, Integer> entry : ctMap.entrySet()) {
            int val = entry.getKey();
            int ct = entry.getValue();
            if (ct == 0) continue;

            // add current val to a permutation
            cur.add(val);
            ctMap.put(val, ct - 1);
            permute(cur);
            // revert for next trial
            cur.removeLast();
            ctMap.put(val, ct);
        }
    }
}


// another solution:

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        generatePermutations(nums, new ArrayList<>(), used, res);
        return res;
    }
    
    private void generatePermutations(int[] nums, List<Integer> curr, boolean[] used, List<List<Integer>> res) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i-1] && !used[i-1])) {
                continue;
            }
            used[i] = true;
            curr.add(nums[i]);
            generatePermutations(nums, curr, used, res);
            used[i] = false;
            curr.remove(curr.size()-1);
        }
    }
