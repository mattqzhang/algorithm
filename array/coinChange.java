/*
lc 322:
https://leetcode.com/problems/coin-change/

    Given coins of different denominations and a total amount of money amount.
    Write a function to compute the fewest number of coins that you need to make up that amount.

    This is a very classic dynamic programming algorithm.
    We tackle the problem recursively, for each coin, if I take that coin into account,
    then the fewest number of coins we can get is 1+coinChange(amount-that_coin_value).
    So for all the coins, we return the smallest number as
        min(1+coinChange(amount-coin1_value), 1+coinChange(amount-coin2_value, ......).
*/

public static int coinChangeRec(int[] coins, int sum, int dp[]) {
    // -1: no solution
    if (sum < 0) return -1;

    // already visited
    if (dp[sum] != -2)  return dp[sum];

    int min = sum + 1;
    // try each coins, recursively compute the solution
    for (int i = 0; i < coins.length; i++) {
        int ct = coinChangeRec(coins, sum - coins[i], dp);
        if (ct >= 0 && ct < min)
            min = ct + 1;
    }
    min = (min == sum + 1) ? -1 : min;
    dp[sum] = min;
    return min;
}

public static int coinChange(int[] coins, int sum) {
    // solution from 0 to sum
    int dp[] = new int[sum + 1];
    // -2: not visited
    Arrays.fill(dp, -2);
    dp[0] = 0;
    return coinChangeRec(coins, sum, dp);
}

    /*
    Build it ground up:
    Construct the solution from total amount 0, 1, 2, ...
    For amount N, remove a coin C and get previous result for N-C
    * */
public int coinChange(int[] coins, int sum) {
    int[] dp = new int[sum + 1];
    // max possible # of coins is sum, so set default to sum+1
    Arrays.fill(dp, sum+1);
    dp[0] = 0;
    // go through each sum i
    for(int i=1; i<=sum; i++){
        // reduce a coin j, and compare with the result of i-j computed before
        for(int j=0; j<coins.length; j++){
            if(coins[j] <= i)
                dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
        }
    }
    // if sum+1 means no solution
    return dp[sum] == sum + 1 ? -1 : dp[sum];
}
