/*
Sparse Matrix Multiplication
Given two sparse matrices A and B, return the result of AB.
*/

// solution 1: use hashmap for one matrix:
public int[][] multiply(int[][] A, int[][] B) {
    if(A.length == 0 || B.length == 0)
        return new int[0][0];

    int[][] res = new int[A.length][B[0].length];
    //get hashmap for B: i, <j, val>
    Map<Integer, Map<Integer, Integer>> rowsOfB = new HashMap<> ();
    for(int i=0; i<B.length; i++){
        for(int j=0; j<B[0].length; j++){
            if(B[i][j] != 0){
                if(!rowsOfB.containsKey(i)){
                    rowsOfB.put(i, new HashMap<Integer, Integer>());
                }
                rowsOfB.get(i).put(j, B[i][j]);
            }
        }
    }

    // compute sum, only need to iterate non-null values of B, in the HashMap.
    for(int i=0; i<A.length; i++){
        for(int j=0; j<A[0].length; j++){
            if(A[i][j] != 0 && rowsOfB.containsKey(j)){
                Map<Integer, Integer> hm = rowsOfB.get(j);
                for(Map.Entry<Integer, Integer> entry : hm.entrySet()){
                    res[i][entry.getKey()] += A[i][j] * entry.getValue();
                }
            }
        }
    }
    return res;
}

// solution 2: use HashMap for both matrices
public int[][] multiply(int[][] A, int[][] B) {
    if (A == null || B == null) return null;
    int rowA = A.length, colA = A[0].length;
    int rowB = B.length, colB = B[0].length;

    Map<int[], Integer> mapA = new HashMap<>();
    for (int i = 0; i < rowA; i++) {
        for (int j = 0; j < colA; j++) {
            if (A[i][j] != 0)
                mapA.put(new int[]{i, j}, A[i][j]);
        }
    }

    Map<int[], Integer> mapB = new HashMap<>();
    for (int i = 0; i < rowB; i++) {
        for (int j = 0; j < colB; j++) {
            if (B[i][j] != 0)
                mapB.put(new int[]{i, j}, B[i][j]);
        }
    }

    int[][] C = new int[rowA][colB];
    for (int[] posA : mapA.keySet()) {
        for (int[] posB : mapB.keySet()) {
            if (posA[1] == posB[0]) {
                C[posA[0]][posB[1]] += mapA.get(posA) * mapB.get(posB);
            }
        }
    }
    return C;
}
