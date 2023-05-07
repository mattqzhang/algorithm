/*
Filling Bookcase Shelves

We want to place these books "in order" onto bookcase shelves that have a total width shelfWidth.


lc 1105
https://leetcode.com/problems/filling-bookcase-shelves/description/
*/


    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        // height at each step
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            int height = 0, width = 0;

            // keep adding books before i
            for (int j = i; j >= 1; j--) {
                width += books[j - 1][0];
                if (width > shelfWidth) {
                    break;
                }
                // current height, after adding j-1
                height = Math.max(height, books[j - 1][1]);
                // update dp of current solution
                // note all books from j-1 to i are now in current, so add to dp[j-1]
                dp[i] = Math.min(dp[i], dp[j - 1] + height);
            }
        }
        return dp[n];        
    }
