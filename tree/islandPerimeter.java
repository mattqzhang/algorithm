/*
Island Perimeter

lc 463
https://leetcode.com/problems/island-perimeter/description/
*/

    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int edges = 0;

        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++) {
                // for each island, check all its 4 neighbors.
                // if the neighbor is 0, there's an edge.
                if (grid[i][j] == 1) {
                    if (i==0 || (i>0 && grid[i-1][j] == 0)) edges++;
                    if (i==m-1 || (i<m-1 && grid[i+1][j] == 0)) edges++;
                    if (j==0 || (j>0 && grid[i][j-1] == 0)) edges++;
                    if (j==n-1 || (j<n-1 && grid[i][j+1] == 0)) edges++;
                }
            }
        }
        return edges;
    }
