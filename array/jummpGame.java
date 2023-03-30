/*
Jump Game
You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.

lc 55
https://leetcode.com/problems/jump-game/description/
*/

   public boolean canJump(int[] nums) {
        int n = nums.length;
        int reach[] = new int[n];
        reach[0] = 1;
        for (int i=0; i<n; i++) {
            // cannot proceed
            if (reach[i] == 0)
                return false;
            // covers the end
            if (i + nums[i] >= n-1)
                return true;
            // reachable from i
            for (int j=1; j <= nums[i]; j++) {
                reach[i+j] = 1;
            }
        }
        return true;
    }



    // recursive algo, will time out when input is big
    boolean dfs(int k, int[] reach, int nums[]) {
        int n = reach.length;
        if (nums[k] + k >= n-1)
            return true;
        for (int i=1; i<=nums[k]; i++) {
            reach[k+i] = 1;
            if (dfs(k+i, reach, nums))
                return true;
        }
        return false;
    }

    public boolean canJump(int[] nums) {
        int n = nums.length;
        int reach[] = new int[n];
        reach[0] = 1;
        return dfs(0, reach, nums);
    }
