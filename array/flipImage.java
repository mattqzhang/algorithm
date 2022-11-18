/*
lc 832:
https://leetcode.com/problems/flipping-an-image/

Flipping an image
Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.
*/

/** After flip:
     A[i][j]  <--> A[i][N-1-j]
 After inverse:
 1 0  --> 0 1 --> 1 0  same
 0 1  --> 1 0 --> 0 1  same
 1 1  --> 1 1 --> 0 0   1-A[i][j] or  1 ^ A[i][j]
 0 0  --> 0 0 --> 1 1   1-A[i][j]
 */

public int[][] flipAndInvertImage(int[][] A) {
    int N = A.length;
    for(int i=0; i<N; i++){
        for(int j=0; j<N/2; j++)
            if(A[i][j] == A[i][N-1-j]) {
                A[i][j] = 1 - A[i][j];
                A[i][N-1-j] = 1 - A[i][N-1-j];
            }
        if(N%2 == 1)
            A[i][(int)N/2] = 1 - A[i][(int)N/2];
    }
    return A;
}

/** Solve by using xor */
public int[][] flipAndInvertImage(int[][] A) {
    int C = A[0].length;
    for (int[] row: A)
        for (int i = 0; i < (C + 1) / 2; ++i) {
            // xor, and swap
            int tmp = row[i] ^ 1;
            row[i] = row[C - 1 - i] ^ 1;
            row[C - 1 - i] = tmp;
        }

    return A;
}
