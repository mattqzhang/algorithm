/*
Detect Cycles in 2D Grid

lc 1559
https://leetcode.com/problems/detect-cycles-in-2d-grid/description/
*/

   // DFS

    class Pair{
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    int m, n;
    boolean visited[][];

    int[] movex = {1, -1, 0, 0};
    int[] movey = {0, 0, 1, -1};

    boolean dfs(int x, int y, char[][] grid, Pair pre, char c) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newx = x + movex[i];
            if (newx < 0 || newx >= m) continue;
            int newy = y + movey[i];
            if (newy < 0 || newy >= n) continue;

            if ((pre == null || !(pre.x == newx && pre.y == newy))
                    && grid[newx][newy] == c) {
                if (visited[newx][newy]) {
                    return true;
                } else if (dfs(newx, newy, grid, new Pair(x, y), c))
                    return true;
            }
        }
        return false;
    }

    public boolean containsCycle(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i<m; i++) {
            for (int j = 0; j<n; j++) {
                if (!visited[i][j]) {
                    if (dfs(i, j, grid, null, grid[i][j]))
                        return true;
                }
            }
        }
        return false;
    }

 /*****************************************************/
  
 // BFS

    class Loc{
        int x;
        int y;
        int px;  // parent's x
        int py;  // parent's y
        public Loc(int x, int y, int px, int py) {
            this.x = x;
            this.y = y;
            this.px = px;
            this.py = py;
        }
    }

    int[] movex = {1, 0, -1, 0};
    int[] movey = {0, 1, 0, -1};

    // bfs, simpler, as we don't need to track the previous node
    public boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        Queue<Loc> qe = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (!visited[i][j]) {
                    visited[i][j] = true;
                    qe.offer(new Loc(i, j, -1, -1));

                    while (!qe.isEmpty()) {
                        Loc cur = qe.poll();
                        char c = grid[cur.x][cur.y];

                        for (int d = 0; d < 4; d++) {
                            int newx = cur.x + movex[d];
                            if (newx < 0 || newx >= m) continue;
                            int newy = cur.y + movey[d];
                            if (newy < 0 || newy >= n) continue;

                            // explore neighbors with same char
                            if (grid[newx][newy] == c && !(newx == cur.px && newy == cur.py)) {
                                if (visited[newx][newy])  // find cycle
                                    return true;
                                else {
                                    visited[newx][newy] = true;
                                    qe.offer(new Loc(newx, newy, cur.x, cur.y));
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
