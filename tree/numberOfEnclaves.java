/*
Number of Enclaves
You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.
A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.
Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.


lc 1020
https://leetcode.com/problems/number-of-enclaves/description/
*/

    void expand(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if (i>=m || i<0 || j>=n  || j<0 || grid[i][j] != 1)
            return;
        
        grid[i][j] = 0;
        expand(grid, i+1, j);
        expand(grid, i-1, j);
        expand(grid, i, j+1);
        expand(grid, i, j-1);        
    }
    
    // starting from 1's on the boundaries, and expand.
    // finally count the ones left
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // expand from the boundaries ones
        for (int i=0; i<m; i++) {
            if (grid[i][0] == 1)
                expand(grid, i, 0);            
            if (grid[i][n-1] == 1)
                expand(grid, i, n-1);
        }
        for (int i=0; i<n; i++) {
            if (grid[0][i] == 1)
                expand(grid, 0, i);
            if (grid[m-1][i] == 1)
                expand(grid, m-1, i);
        }        
        
        // count remaining ones in the middle
        int ct = 0;
        for (int i=1; i<grid.length-1; i++) {
            for (int j=1; j<grid[i].length-1; j++) {
                if (grid[i][j] == 1) ct ++;
            }
        }
        return ct;
    }
