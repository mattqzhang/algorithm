/*
Vertical Order Traversal of Binary Tree
Given a binary tree, return the vertical order traversal of its nodes values.

lc 987
https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/description/
*/

// DFS to build the TreeMap
private void dfs(TreeNode node, int x, int y, TreeMap<Integer, List<int[]>> map) {
    if(node == null)
        return;
    if(!map.containsKey(x))
        map.put(x, new ArrayList<>());
    map.get(x).add(new int[]{y, node.val});
    dfs(node.left, x-1, y-1, map);
    dfs(node.right, x+1, y-1, map);
}

public List<List<Integer>> verticalTraversal(TreeNode root) {
    TreeMap<Integer, List<int[]>> map = new TreeMap(); //(x: (y, val))
    List<List<Integer>> res = new ArrayList<>();
    dfs(root, 0, 0, map);

    for(List<int[]> y_val: map.values()) {
        Collections.sort(y_val, new Comparator<int[]>(){
            @Override
            public int compare(int[] a1, int[] a2){
                // sort by level value in reverse order(big -> small, top -> bottom)
                //  for the same level, order by value
                return a1[0] == a2[0] ? a1[1] - a2[1] : a2[0] - a1[0];
            }
        });

        List<Integer> list = new ArrayList<>();
        for(int[] pair: y_val) {
            list.add(pair[1]);
        }
        res.add(list);
    }
    return res;
}
