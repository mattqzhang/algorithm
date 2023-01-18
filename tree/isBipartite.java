/*
Is Graph Bipartite
Given an undirected graph, return true if and only if it is bipartite.
For graph[][], each graph[i] is the neighbor list of node i


lc 785
https://leetcode.com/problems/is-graph-bipartite/
*/

// for each node, retrieve its neighbors in dfs/bfs order, and assign color codes

// dfs
public boolean isBipartite(int[][] graph) {
    int N = graph.length;
    if(N ==0 || N ==1) return true;

    int[] color = new int[N];
    Arrays.fill(color, -1);

    for(int i=0; i<N; i++){
        if(color[i] == -1){ // not visited before
            color[i] = 0;
            Stack<Integer> stk = new Stack<>();
            stk.push(i);
            while(!stk.isEmpty()){
                int idx = stk.pop();
                int c = color[idx];
                int[] nb = graph[idx];
                for(int j=0; j<nb.length; j++){
                    if(color[nb[j]] == c)
                        return false;
                    if(color[nb[j]] == -1) {
                        color[nb[j]] = 1 - c;
                        stk.push(nb[j]);
                    }
                }
            }
        }
    }
    return true;
}

// bfs
public boolean isBipartite(int[][] graph) {
    // # of nodes in the graph
    int n = graph.length;
    int[] color = new int[n];
    // 0: not visited, 1, -1: different groups
    Arrays.fill(color, 0);

    for(int i=0; i<n; i++){
        if(color[i] == 0) { // not visited
            Queue<Integer> qe = new LinkedList<Integer>();
            qe.offer(i);
            color[i] = 1;

            while(!qe.isEmpty()) {
                int node = qe.poll();
                int[] nb = graph[node];
                for (int j = 0; j < nb.length; j++) {
                    if (color[nb[j]] == 0){
                        qe.offer(nb[j]);
                        color[nb[j]] = 0 - color[node];
                    }else if(color[nb[j]] == color[node])
                        return false;
                }
            }
        }
    }
    return true;
}
