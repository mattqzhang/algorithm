/*
Coin Change II
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.
You may assume that you have an infinite number of each kind of coin.

lc 518
https://leetcode.com/problems/coin-change-ii/description/
*/

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 0);
        dp[0] = 1;

        // add one coin at a time.
        for(int coin : coins)
            for(int i=coin; i<=amount; i++) 
                dp[i] += dp[i - coin];

        return dp[amount];
    }
