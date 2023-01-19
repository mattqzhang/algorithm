*
Unique Path in a Grid
Problem description:  https://www.interviewbit.com/problems/unique-paths-in-a-grid/

Given a grid of size m * n, lets assume you are starting at (1,1) and your goal is to reach (m,n).
At any instance, if you are on (x,y), you can either go to (x, y + 1) or (x + 1, y).
Now consider if some obstacles are added to the grids. How many unique paths would there be?
An obstacle and empty space is marked as 1 and 0 respectively in the grid.
Example :
There is one obstacle in the middle of a 3x3 grid as illustrated below.
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

lc 63
https://leetcode.com/problems/unique-paths-ii/
 */

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];
        if (obstacleGrid[0][0] == 1)  return 0;
        dp[0][0] = 1;

        // initialize 1st row and 1st column
        for (int i=1; i<m; i++) {
            dp[i][0] = (obstacleGrid[i][0] == 1) ? 0 : dp[i-1][0];
        }
        for (int j=1; j<n; j++) {
            dp[0][j] = (obstacleGrid[0][j] == 1) ? 0 : dp[0][j-1];
        }

        // dp solve the problem
        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                } 
                  
            }
        }

        return dp[m-1][n-1];
    }
}




// another function signature and solution

public static int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> A) {
    int m = A.size();
    int n = A.get(0).size();

    /* init root */
    int[][] path = new int[m][n];
    if(A.get(0).get(0) == 0)
        path[0][0] = 1;
    else {
        path[0][0] = 0;
        return 0;
    }

    /* init 1st row and 1st column */
    for(int i=1; i < n; i++)
        path[0][i] = A.get(0).get(i) == 1 ? 0 : path[0][i-1];
    for(int i=1; i < m; i++)
        path[i][0] = A.get(i).get(0) == 1 ? 0 : path[i-1][0];

    /* path[i][j] = path[i-1][j] + path[i][j-1] */
    for(int i=1; i<m; i++){
        for(int j=1; j<n; j++){
            path[i][j] = 0;
            if(A.get(i-1).get(j) == 0)
                path [i][j] += path[i-1][j];
            if(A.get(i).get(j-1) == 0)
                path[i][j] += path[i][j-1];
        }
    }
    return path[m-1][n-1];
}
