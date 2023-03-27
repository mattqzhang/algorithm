/*
You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

lc 48
https://leetcode.com/problems/rotate-image/description/
*/

    /*
     * clockwise rotate
     * first reverse up to down, then swap the symmetry
     * 1 2 3     7 8 9     7 4 1
     * 4 5 6  => 4 5 6  => 8 5 2
     * 7 8 9     1 2 3     9 6 3
     */

    /*
     * anticlockwise rotate
     * first reverse left to right, then swap the symmetry
     * 1 2 3     3 2 1     3 6 9
     * 4 5 6  => 6 5 4  => 2 5 8
     * 7 8 9     9 8 7     1 4 7
     */

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // reverse: swap row i with row n-i
        for (int i=0; i<n/2; i++) {
            for (int j = 0; j<n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-1-i][j];
                matrix[n-1-i][j] = tmp;
            }
        }

        // tanspose, swap m[i][j] with m[j][i]
        for (int i=0; i<n; i++) {
            for (int j = i+1; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
