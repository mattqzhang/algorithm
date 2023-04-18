/*
Surrounded Regions
Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.

lc 130
https://leetcode.com/problems/surrounded-regions/description/
*/

    void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i>board.length-1 || j>board[0].length - 1)
            return;

        // expand from 'O', mark as 'Y'
        if (board[i][j] == 'O') {
            board[i][j] = 'Y';
            dfs(board, i - 1, j);
            dfs(board, i, j - 1);
            dfs(board, i + 1, j);
            dfs(board, i, j + 1);
        }
    }

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        if (m==0 || n ==0) return;

        // expand from 4 sides of the board
        for (int i=0; i<n; i++) {
            dfs(board, 0, i);
            dfs(board, m-1, i);
        }
        for (int i=0; i<m; i++) {
            dfs(board, i, 0);
            dfs(board, i, n-1);
        }

        // mark the remaining 'O' to 'X', and revert 'Y' to 'O'
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == 'Y') board[i][j] = 'O';
            }
        }
    }
