/*
Make a larger island
You are given an n x n binary matrix grid. You are allowed to change at most one 0 to be 1.
Return the size of the largest island in grid after applying this operation.
An island is a 4-directionally connected group of 1s.

lc 827
https://leetcode.com/problems/making-a-large-island/
*/


// solution 1 Brute force, check at each node

public class Solution {

    // moving direction of row and column, to identify neighbors
    int[] dr = new int[]{-1, 0, 1, 0};
    int[] dc = new int[]{0, -1, 0, 1};

    public int largestIsland(int[][] grid) {
        int N = grid.length;

        int ans = 0;
        for (int r = 0; r < N; ++r)
            for (int c = 0; c < N; ++c)
                if (grid[r][c] == 0) {
                    grid[r][c] = 1;
                    ans = Math.max(ans, check(grid, r, c));
                    grid[r][c] = 0;
                }

        return ans > 0 ? ans : N * N;
    }

    public int check(int[][] grid, int r0, int c0) {
        int N = grid.length;
        Stack<Integer> stack = new Stack();
        Set<Integer> seen = new HashSet();
        stack.push(r0 * N + c0);
        seen.add(r0 * N + c0);

        while (!stack.isEmpty()) {
            int code = stack.pop();
            int r = code / N, c = code % N;
            for (int k = 0; k < 4; ++k) {
                int nr = r + dr[k], nc = c + dc[k];
                if (!seen.contains(nr * N + nc) && 0 <= nr && nr < N &&
                        0 <= nc && nc < N && grid[nr][nc] == 1) {
                    stack.push(nr * N + nc);
                    seen.add(nr * N + nc);
                }
            }
        }

        return seen.size();
    }


///////////////////////////////////////
// Solution 2: DFS, record the groups

class Solution {
    
    // moving direction of row and column, to identify neighbors
    int[] dr = new int[]{-1, 0, 1, 0};
    int[] dc = new int[]{0, -1, 0, 1};
    int[][] grid;
    int N;

    public int largestIsland(int[][] grid) {
        this.grid = grid;
        N = grid.length;

        // group id. Start from 2, to avoid mismatch with node value 1.
        int gId = 2;
        int[] groupSize = new int[N * N + 2];
        for (int r = 0; r < N; ++r) {
            for (int c = 0; c < N; ++c) {
                if (grid[r][c] == 1) {// un-visited node
                    //increase group id after completion of one dfs search (group exploration)
                    groupSize[gId] = dfs(r, c, gId++);
                }
            }
        }
        
        int maxSize = 0;
        // we need this step, as if we have all "1"s, the following flip block won't run
        for (int x : groupSize)
            maxSize = Math.max(maxSize, x);

        // flip once, to connect two groups
        for (int r = 0; r < N; ++r) {
            for (int c = 0; c < N; ++c) {
                if (grid[r][c] == 0) { // flip this node
                    // store the connected index/group id for this node
                    Set<Integer> currGroup = new HashSet();
                    // loop each of the 4 neighbors
                    for (Integer move : neighbors(r, c)) {
                        // this neighbor belongs to a group, index is the grid value
                        if (grid[move / N][move % N] > 1) {
                            // add this indx / group id
                            currGroup.add(grid[move / N][move % N]);
                        }
                    }

                    // base size = 1, is this flipped node
                    int gSize = 1;
                    // add all the connected group size to this node
                    for (int i : currGroup)
                        gSize += groupSize[i];
                    maxSize = Math.max(maxSize, gSize);
                }
            }
        }

        return maxSize;
    }

    // if Node(r, c) has groupId,
    // dfs to recursively mark all it's neighbors the same index
    // return # of nodes with the same index marked
    public int dfs(int r, int c, int groudId) {
        int size = 1;
        grid[r][c] = groudId;
        for (Integer move : neighbors(r, c)) {
            if (grid[move / N][move % N] == 1) {  // ==1 is un-visited neighbor
                grid[move / N][move % N] = groudId;
                size += dfs(move / N, move % N, groudId);
            }
        }

        return size;
    }

    // get list of neighbor coordinates for (r, c)
    public List<Integer> neighbors(int r, int c) {
        List<Integer> neighborList = new ArrayList();
        for (int k = 0; k < 4; ++k) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            if (0 <= nr && nr < N && 0 <= nc && nc < N)
                neighborList.add(nr * N + nc);
        }

        return neighborList;
    }
}
