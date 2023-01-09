/*
Print all paths from root to leaf
We can do it recursively, top down or bottom up.
*/

//bottom up, union children paths, and then add root to head of all children path.
public List<String> binaryTreePaths(TreeNode root) {
    List<String> res = new LinkedList<String>();
    if(root == null)
        return res;

    List<String> leftPaths = binaryTreePaths(root.left);
    List<String> rightPaths = binaryTreePaths(root.right);

    List<String> newPaths = new LinkedList<String>();
    if(leftPaths != null)
        newPaths.addAll(leftPaths);
    if(rightPaths != null)
        newPaths.addAll(rightPaths);

    if(newPaths.size() == 0)
        res.add(Integer.toString(root.val));
    else {
        for (int i = 0; i < newPaths.size(); i++) {
            String path = newPaths.get(i);
            path = root.val + "->" + path;
            res.add(path);
        }
    }
    return res;
}

// top down, new a path obj for each child node, until leaf and print
public void printAllRootToLeafPaths(Node node, ArrayList path) 
{
    if(node==null)
    {
        return;
    }
    path.add(node.data);

    if(node.left==null && node.right==null)
    {
        System.out.println(path);
        return;
    }
    else
    {
        printAllRootToLeafPaths(node.left, new ArrayList(path));
        printAllRootToLeafPaths(node.right, new ArrayList(path));
    }      
}
