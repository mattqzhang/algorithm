/*
Number of Islands
Given a 2-d grid map of '1's (land) and '0's (water), count the number of islands.

lc 200
https://leetcode.com/problems/number-of-islands/
*/


public static void merge(char[][] grid, int i, int j){
    int m = grid.length;
    int n = grid[0].length;

    // only mark '1's
    if(i<0 || i>=m || j<0 || j>=n || grid[i][j] != '1')
        return;

    // mark grid[i][j]
    grid[i][j]='X';

    // recursively mark all connected neighbors
    merge(grid, i-1, j);
    merge(grid, i+1, j);
    merge(grid, i, j-1);
    merge(grid, i, j+1);
}

public static int numIslands(char[][] grid) {
    if(grid==null || grid.length==0||grid[0].length==0)
        return 0;

    int m = grid.length;
    int n = grid[0].length;

    int count = 0;
    for(int i=0; i<m; i++){
        for(int j=0; j<n; j++){
            if(grid[i][j] == '1') {
                count ++;
                merge(grid, i, j);
            }
        }
    }
    return count;
}

