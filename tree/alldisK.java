/*
All Nodes distance K in binary tree
We are given a binary tree (with root node root), a target node, and an integer value K.
Return a list of the values of all nodes that have a distance K from the target node.  The answer can be returned in any order.

lc 863
https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
*/

Map<TreeNode, TreeNode> parent;

//annotate all parent nodes
public void dfs(TreeNode node, TreeNode par) {
    if (node != null) {
        parent.put(node, par);
        dfs(node.left, node);
        dfs(node.right, node);
    }
}

// bfs
// start from target, put all its left, right, parent into a queue
// repeat until goes to dist k
public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
    parent = new HashMap();
    dfs(root, null);

    // bfs queue
    Queue<TreeNode> queue = new LinkedList();
    queue.add(null);  // separator for bfs level, each level is started with a null node
    queue.add(target);

    // visited nodes at each level/distance
    Set<TreeNode> seen = new HashSet();
    seen.add(target);
    seen.add(null);  // separator for each level

    int dist = 0;
    while (!queue.isEmpty()) {
        TreeNode node = queue.poll();
        if (node == null) {  // started a new level
            if (dist == K) {  // this is level K, answer found
                List<Integer> ans = new ArrayList();
                for (TreeNode n: queue)
                    ans.add(n.val);
                return ans;
            }
            // otherwise add this null to end of queue, as the mark for next level
            queue.offer(null);
            dist++;
        } else {
            // add all neighbor nodes in tree.
            if (!seen.contains(node.left)) {
                seen.add(node.left);
                queue.offer(node.left);
            }
            if (!seen.contains(node.right)) {
                seen.add(node.right);
                queue.offer(node.right);
            }
            TreeNode par = parent.get(node);
            if (!seen.contains(par)) {
                seen.add(par);
                queue.offer(par);
            }
        }
    }

    return new ArrayList<Integer>();
}
