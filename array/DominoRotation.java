/*
lc 1007
https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/

Minimum Domino Rotations For Equal Row
In a row of dominoes, A[i] and B[i] represent the top and bottom halves of the i-th domino.  (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)
We may rotate the i-th domino, so that A[i] and B[i] swap values.
Return the minimum number of rotations so that all the values in A are the same, or all the values in B are the same.
*/

// rotate A or B so that all values become x
public int getRotateCt(int[] A, int[] B, int x){
    int cta = 0, ctb = 0, n = A.length;
    for(int i=0; i<n; i++){
        if(A[i] != x && B[i] != x)
            return -1;
        if(A[i] !=x ) // B will be x
            cta ++;
        if(B[i] !=x)  // A will be x
            ctb ++;
        // else: both of them are x, no need to increase ct
    }
    return Math.min(cta, ctb);
}


public int minDominoRotations(int[] A, int[] B) {
    if(A.length == 1)
        return 0;

    // final result must be A[0] or B[0]
    int cta = 0, ctb =0;

    cta = getRotateCt(A, B, A[0]);
    ctb = getRotateCt(A, B, B[0]);
    if(cta < 0) return ctb;
    if(ctb < 0) return cta;
    return Math.min(cta, ctb);

}
