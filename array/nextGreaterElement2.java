/*
Next Greater Element II
Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.

lc 503
https://leetcode.com/problems/next-greater-element-ii/description/
*/

    public int[] nextGreaterElements(int[] nums) {
        // index -> pre_max value
        Map<Integer, Integer> hm = new HashMap<>();
        int n = nums.length;
        int res[] = new int[n];
        Stack<Integer> stk = new Stack<>();
        // similar to the problem next Greater Element 1, but we store only index to hm here
        // if data points in the stack is smaller than the current one, pop all those smaller
        //  and save the <index, val> mapping to hashmap.
        // We iterate to 2n for the circular array, and %n to get the index
        for (int i=0; i< n * 2; i++) {
            while (!stk.isEmpty() && nums[stk.peek() % n] < nums[i % n]) {
                hm.put(stk.pop(), nums[i % n]);
            }
            stk.push(i);
        }
        // remaining ones in stack are in decreasing order
        while (!stk.isEmpty()) {
            hm.put(stk.pop(), -1);
        }
        // copy to result
        for (int i=0; i<n; i++) {
            res[i] = hm.get(i);
        }
        return res;
    }
