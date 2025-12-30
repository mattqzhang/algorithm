/*
Find All Numbers Disappeared in an Array

lc 448
https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
*/

    // general idea: to put number i in place i.
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new LinkedList<>();
        int n = nums.length;

        int i = 0;
        while(i < n) {
            int idx = nums[i] - 1;
            if (nums[i] != nums[idx]) {
                //swap so that num[idx] = idx
                int tmp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = tmp;
            } else
                i++;
        }
        for (i = 0; i<n; i++) {
            if (nums[i] != i+1)
                res.add(i+1);
        }
        return res;        
    }
