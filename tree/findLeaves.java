/*
Find Leaves of binary tree
Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.
*/

// height --> list of nodes mapping
HashMap<Integer, List<Integer>> hm = new HashMap<>();
int maxHeight=-1;

public List<List<Integer>> findLeaves(TreeNode root) {
    buildHeight(root);
    List<List<Integer>> res = new ArrayList<>();
    for(int i=0; i<=maxHeight; i++){
        res.add(hm.get(i));
    }
    return res;
}

public int buildHeight(TreeNode root){
    if(root == null)
        return -1;

    int height = Math.max(buildHeight(root.left), buildHeight(root.right)) +1;

    List<Integer> list;
    if(hm.containsKey(height)){
        list = hm.get(height);
    }else{
        list = new ArrayList<>();
    }
    list.add(root.val);
    hm.put(height, list);
    if(height > maxHeight)
        maxHeight = height;
    return height;
}
