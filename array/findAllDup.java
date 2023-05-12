/*
Find All Duplicates in an Array
Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears once or twice, return an array of all the integers that appears twice.

You must write an algorithm that runs in O(n) time and uses only constant extra space.

lc 442
https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
*/

// using hashmap, but it's O(n) extra space

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new LinkedList<>();
        // <value -> hasDup>
        HashMap<Integer, Boolean> hm = new HashMap<>();
        for (int v : nums) {
            if (!hm.containsKey(v)) {
                hm.put(v, false);
            } else {
                if (hm.get(v) == false) {
                    hm.put(v, true);
                    result.add(v);
                }
            }
        }
        return result;        
    }



// O(1) extra space 

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            // for each nums[i], mark the corresponding entry nums[nums[i]] negative.
            int index = Math.abs(nums[i]) - 1;
            
            // Mark the element as visited by negating its value
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            } else {
                // If the element is already marked negative, it means we have seen it before
                duplicates.add(Math.abs(nums[i]));
            }
        }
        
        return duplicates;     
    }

