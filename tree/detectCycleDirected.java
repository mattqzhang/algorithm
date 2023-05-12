/*
Detect Cycle in directed graph

if there's a cycle:
- dfs
- found a node visited, and also in the recursion stack
*/

// graph[i][j]: exists edge node i --> node j
public boolean hasCycle(int[][] graph) {
    int n = graph.length;
    boolean[] visited = new boolean[n];
    boolean[] recStack = new boolean[n];
    
    for (int i = 0; i < n; i++) {
        if (!visited[i] && dfs(i, visited, recStack, graph)) {
            return true;
        }
    }
    
    return false;
}

private boolean dfs(int i, boolean[] visited, boolean[] recStack, int[][] graph) {
    visited[i] = true;
    // setup recursion stack for each dfs explore path
    recStack[i] = true;
    
    for (int j : graph[i]) {
        if (!visited[j]) {
            if (dfs(j, visited, recStack, graph)) {
                return true;
            }
        } else if (recStack[j]) {
            return true;
        }
    }

    // reset after this path is explored
    recStack[i] = false;
    return false;
}
