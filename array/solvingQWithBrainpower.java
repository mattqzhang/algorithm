/*

Solving Questions With Brainpower
You are given a 0-indexed 2D integer array questions where questions[i] = [pointsi, brainpoweri].

lc 2140
https://leetcode.com/problems/solving-questions-with-brainpower/description/
*/

   // DP from end of array, and compute reversely
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long dp[] = new long[n];

        // base case
        dp[n-1] = questions[n-1][0];
        long max = dp[n-1];

        for (int i=n-2; i>=0; i--) {
            int next = i + questions[i][1] + 1;
            // at each step, we can take i, or skip i, and take dp[i+1]
            //  this is why we do dp backwards.
            if (next > n-1) {
                dp[i] = Math.max(questions[i][0], dp[i+1]);
            } else {
                dp[i] = Math.max(questions[i][0] + dp[next], dp[i+1]);
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
