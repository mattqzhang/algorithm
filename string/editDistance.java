/*
Edit Distance
Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
You have the following 3 operations permitted on a word: Insert/Delete/Replace a character

lc 72
https://leetcode.com/problems/edit-distance/
*/

// recursion

    public int minDistance(String word1, String word2) {
        return minDistance(word1, word2, word1.length()-1, word2.length()-1);
    }

    // the idx1 and idx2 goes backwardse
    public int minDistance(String word1, String word2, int idx1, int idx2) {
        if (idx1 == -1) return idx2 + 1;
        if (idx2 == -1) return idx1 + 1;

        if (word1.charAt(idx1) == word2.charAt(idx2)) {
            return minDistance(word1, word2, idx1-1, idx2-1);
        }
        // insert char into w1
        int insertOp = minDistance(word1, word2, idx1, idx2-1);
        // delete char at w1
        int delOp = minDistance(word1, word2, idx1-1, idx2);
        // replace both chars
        int repOp = minDistance(word1, word2, idx1-1, idx2-1);
        return Math.min(Math.min(insertOp, delOp), repOp) + 1;
    }



// DP
public int minDistance(String word1, String word2) {
    int n = word1.length();
    int m = word2.length();

    // if one of the strings is empty
    if (n * m == 0)
        return n + m;

    // array to store the convertion history
    int[][] d = new int[n + 1][m + 1];

    // init boundaries
    for (int i = 0; i < n + 1; i++) {
        d[i][0] = i;
    }
    for (int j = 0; j < m + 1; j++) {
        d[0][j] = j;
    }

    // DP compute
    for (int i = 1; i < n + 1; i++) {
        for (int j = 1; j < m + 1; j++) {
            int left = d[i - 1][j] + 1;
            int down = d[i][j - 1] + 1;
            int diag = d[i - 1][j - 1];
            // i-1 starts from the 0th char
            if (word1.charAt(i - 1) != word2.charAt(j - 1))
                diag += 1;
            d[i][j] = Math.min(left, Math.min(down, diag));
        }
    }
    return d[n][m];
}
