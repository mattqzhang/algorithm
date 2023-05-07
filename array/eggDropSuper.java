/*
Super Egg Drop
You are given k identical eggs and you have access to a building with n floors labeled from 1 to n.

lc 887
https://leetcode.com/problems/super-egg-drop/description/
*/


// binary search the test floor

    public int superEggDrop(int k, int n) {
        // [egg, floor]
        int dp[][] = new int[k][n+1];

        // floor 1
        for (int i=0; i < k; i++) {
            dp[i][0] = 0;
            dp[i][1] = 1;
        }
        // one egg
        for (int i=1; i<=n; i++) {
            dp[0][i] = i;
        }

        // go through each floor
        for (int i=2; i<=n; i++) {
            // for each possible egg number
            for (int j=1; j<k; j++) {

                dp[j][i] = Integer.MAX_VALUE;
                int lo = 1, hi = i;

                // binary search which floor to throw the first egg
                while (lo <= hi) {
                    int mid = (lo + hi) / 2;
                    int left = dp[j-1][mid - 1];
                    int right = dp[j][i - mid];
                    int cost = 1 + Math.max(left, right);
                    dp[j][i] = Math.min(dp[j][i], cost);

                    // f is too small
                    if (left < right)
                        lo = mid + 1;
                    else
                        hi = mid - 1;
                }
            }
        }
        return dp[k-1][n];
    }


// valid DP solution, similar to the egg drop with 2 eggs problem
// but times out for large input

    public int superEggDrop(int k, int n) {
        // [egg, floor]
        int dp[][] = new int[k][n+1];

        // floor 1
        for (int i=0; i<k; i++) {
            dp[i][1] = 1;
        }
        // one egg
        for (int i=0; i<=n; i++) {
            dp[0][i] = i;
        }

        // go through each floor
        for (int i=2; i<=n; i++) {
            // for each possible egg number
            for (int j=1; j<k; j++) {
                dp[j][i] = Integer.MAX_VALUE;
                // we can decide to drop the 1st egg at floor f
                for (int f = 1; f <= i; f++) {
                    int cost = Math.max(dp[j-1][f - 1],dp[j][i - f]) + 1;
                    dp[j][i] = Math.min(dp[j][i], cost);
                }
            }
        }
        return dp[k-1][n];        
    }
