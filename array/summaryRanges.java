/*
You are given a sorted unique integer array nums.

A range [a,b] is the set of all integers from a to b (inclusive).

Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.

Each range [a,b] in the list should be output as:

"a->b" if a != b
"a" if a == b


lc 228
https://leetcode.com/problems/summary-ranges/description/
*/

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new LinkedList<>();
        if (nums.length == 0) return res;

        int start = 0;
        int end = 0;
        int i = 1;
        while(i < nums.length) {
            while (i< nums.length && nums[i] == nums[i-1] + 1) {
                end = i;
                i++;
            }
            // now nums[i] != nums[i-1] or i == nums.length
            // same start/end
            if (start == end) {
                String cur = Integer.toString(nums[start]);
                res.add(cur);
            } else { // start -> end
                String cur = Integer.toString(nums[start]) + "->" + Integer.toString(nums[end]);
                res.add(cur);
            }
            // reset start, end            
            start = i;
            end = i;
            i++;
        }
        // last one is a single group
        if (start != nums.length && start == end) {
            String cur = Integer.toString(nums[start]);
            res.add(cur);
        }
        return res;                
    }
