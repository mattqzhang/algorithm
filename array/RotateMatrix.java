/*
Rotate Matrix
rotate NXN Matrix, turn it by 90 degrees in anti-clockwise direction without using any extra space.
*/

public class RotateMatrix {

    public static void printMatrix(int mat[][]){
        for(int i=0; i<mat.length; i++){
            System.out.println(Arrays.toString(mat[i]));
        }
    }

    // rotate N by N matrix in place
    public static void rotateMatrix(int mat[][]){
        int N = mat.length;
        // each round, go one level inner
        for(int i=0; i< N/2; i++){
            // the starting point of each round
            for(int j=i; j < N-i-1; j++){
                int tmp = mat[i][j];
                mat[i][j] = mat[j][N-1-i];
                mat[j][N-1-i] = mat[N-1-i][N-1-j];
                mat[N-1-i][N-1-j] = mat[N-1-j][i];
                mat[N-1-j][i] = tmp;
            }
        }
    }


    public static void main(String[] args) {

        // Test Case 1
        int mat[][] =
                {
                        {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15, 16}
                };
        printMatrix(mat);
        rotateMatrix(mat);
        System.out.println("after rotate: ");
        printMatrix(mat);

    }
}
