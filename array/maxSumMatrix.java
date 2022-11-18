/*
Find Maximum path sum in matrix
Given a matrix of N * M. Find the maximum path sum in matrix. The maximum path is sum of all elements from first row to last row where you are allowed to move only down or diagonally to left or right. You can start from any element in first row.
*/

int findMaxPath(int mat[][]) {
    int N = mat.length;
    if(N == 0)
        return 0;
    int M = mat[0].length;

    int max = 0;
    int dp[][] = new int[N][M];

    // sum of first row is the element itself
    for(int i=0; i<N; i++)
        dp[0][i] = mat[0][i];

    for(int i=1; i<N; i++){
        for(int j=0; j<M; j++){
            if(j==0)  //first in the row
                dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            else if(j == M-1)  // last in the row
                dp[i][M-1] = Math.max(dp[i-1][M-1], dp[i-1][M-1]);
            else // max of the 3 path from above level
                dp[i][j] = Math.max(Math.max(dp[i-1][j], dp[i-1][j-1]), dp[i-1][j+1]);
            
            max = Math.max(dp[i][j], max);
        }
    }
    return max;
}

