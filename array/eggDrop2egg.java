/*
Egg Drop With 2 Eggs and N Floors
You are given two identical eggs and you have access to a building with n floors labeled from 1 to n.
You know that there exists a floor f where 0 <= f <= n such that any egg dropped at a floor higher than f will break, and any egg dropped at or below floor f will not break.
Return the minimum number of moves that you need to determine with certainty what the value of f is.

lc 1884
https://leetcode.com/problems/egg-drop-with-2-eggs-and-n-floors/description/
*/


// DP to solve it
    public int twoEggDrop(int n) {
        // [egg, floor]
        // dp[i][j]: the solution of dropping i-1 eggs at floor j
        int dp[][] = new int[2][n+1];

        // floor 1, no matter how many eggs, we only need drop once. 
        // Note floor 0 is the base case for computation. all dp[i][0]=0 by default.
        for (int i=0; i<2; i++) {
            dp[i][1] = 1;
        }
        // one egg
        for (int i=0; i<=n; i++) {
            dp[0][i] = i;
        }
        
        // go through each floor
        for (int i=2; i<=n; i++) {
            dp[1][i] = Integer.MAX_VALUE;
            // we can decide to drop the 1st egg at floor k
            for (int k = 1; k<=i; k++) {
                // egg might break, or not break, so have to take the worst case of the two (max)
                // if the 1st egg breaks, you need to check all previous k-1 one by one, which is dp[0][k - 1]
                // if the 1st egg doesn't break, you have 2 eggs and i-k floors to check, which is dp[1][i - k]
                int cost = Math.max(dp[0][k - 1], dp[1][i - k]) + 1;
                // for each possible k, update the solution
                dp[1][i] = Math.min(dp[1][i], cost);
            }
        }
        return dp[1][n];  
    }
