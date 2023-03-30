/*
Word Search
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

lc 79
https://leetcode.com/problems/word-search/description/
*/

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    // you cannot go back a path
                    boolean[][] visited = new boolean[m][n];
                    if (dfs(board, i, j, word, 0, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int index, boolean visited[][]) {
        if (index == word.length()) {
            return true;
        }
        if ( i < 0 || i >= board.length || j < 0 || j >= board[0].length || 
                visited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }

        // it's visited for this path
        visited[i][j] = true;

        boolean found = dfs(board, i+1, j, word, index+1, visited)
                || dfs(board, i-1, j, word, index+1, visited)
                || dfs(board, i, j+1, word, index+1, visited)
                || dfs(board, i, j-1, word, index+1, visited);

        // reset it, as we may visit it again in another path
        visited[i][j] = false;

        return found;
    }
