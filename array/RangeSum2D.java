/*
Range Sum Query - 2D
Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
*/

  /*
   * Apply the 1-D algorith at each row, precompute the row sum
   * from the beginning of each row
   * */
private int[][] rowSum;

public test3(int[][] matrix) {
    if(matrix.length == 0 || matrix[0].length == 0)
        return;

    rowSum = new int[matrix.length][matrix[0].length + 1];
    for(int i=0; i < matrix.length; i++){
        for(int j=0; j<matrix[0].length; j++){
            rowSum[i][j+1] = rowSum[i][j] + matrix[i][j];
        }
    }
}

public int sumRegion(int row1, int col1, int row2, int col2) {
    int sum = 0;
    for(int i=row1; i<=row2; i++){
        sum += rowSum[i][col2 + 1] - rowSum[i][col1];
    }
    return sum;
}

   /*
   Precompute 2-D subset sum
   * */
private int[][] compuSum;

public NumMatrix(int[][] matrix) {
    if(matrix.length == 0 || matrix[0].length == 0)
        return;

    compuSum = new int[matrix.length + 1][matrix[0].length + 1];
    for(int i=0; i < matrix.length; i++){
        for(int j=0; j < matrix[0].length; j++){
            compuSum[i+1][j+1] = compuSum[i+1][j] + compuSum[i][j+1] + matrix[i][j] - compuSum[i][j];
        }
    }
}

public int sumRegion(int row1, int col1, int row2, int col2) {
    return compuSum[row2 + 1][col2 + 1] - compuSum[row2 + 1][col1] - compuSum[row1][col2+1] + compuSum[row1][col1];
}

