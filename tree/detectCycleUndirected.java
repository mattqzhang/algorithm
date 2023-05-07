/*
Detect cycle in undirected graph

if there's a circle:
- dfs
- found a node visited, and it's not the parent of current vertex
*/

    private boolean dfs(Node u, HashSet<Node> visited, Node parent) {
        visited.add(u);

        for (Node v : u.neighbors) {
            if (visited.contains(v)) {
                if (v != parent) {
                    return true;
                }
            } else if (dfs(v, visited, u)) {
                    return true;
            }
        }
        return false;
    }

    boolean isCyclic(Graph graph) {
        HashSet<Node> visited = new HashSet<>();

        for (Node i : graph) {
            if (!visited.contains(i)) {
                if (dfs(i, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }
