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

        // dp to add one book at a time
        for (int i = 1; i <= n; i++) {
            int height = 0, width = 0;

            // add the new book i first, then try add a previous book one by one in the same row
            for (int j = i; j >= 1; j--) {
                // note the j-th book's entry is j-1 in books[]
                width += books[j - 1][0];
                // the j-th book cannot be put in the same row as the new book
                // we break here as from 1 to j is already computed before.
                if (width > shelfWidth) {
                    break;
                }
                // current max height for the row, after adding book j
                height = Math.max(height, books[j - 1][1]);
                // update dp of current solution
                // note all books from j to i are now in current row, 
                // and from 1 to j-1 is solution dp[j-1] in previous rows, so add them up.
                dp[i] = Math.min(dp[i], dp[j - 1] + height);
            }
        }
        return dp[n];        
    }
