/*
Binary Tree Right Side View
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

lc 199
https://leetcode.com/problems/binary-tree-right-side-view/description/
*/

// simple recursion.
//  if left side view, change the code to search left child first

    List<Integer> res;
    void rec(TreeNode root, int level) {
        if (root == null) return;
        // the first node in this leve.
        // as we search right to left, so it's the rightmost for the level
        if (level == res.size())
            res.add(root.val);

        // search right, then left
        rec(root.right, level+1);
        rec(root.left, level+1);
    }

    public List<Integer> rightSideView(TreeNode root) {
        res = new LinkedList<>();
        if (root == null) return res;

        rec(root, 0);
        return res;
    }


---------------------------------------------------------------

// breadth first search, look for last element of each row
public List<Integer> rightSideView(TreeNode root) {
    List<Integer> rightView = new LinkedList<Integer>();
    if(root == null)
        return rightView;

    Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
    Queue<Integer> depthQueue = new LinkedList<Integer>();
    nodeQueue.add(root);
    depthQueue.add(0);

    int preVal = 0;
    int preDepth = -1;

    while(!nodeQueue.isEmpty()){
        TreeNode cur = nodeQueue.remove();
        int depth = depthQueue.remove();
        // new level, add previous last one
        if(depth > preDepth && preDepth >=0){
            rightView.add(new Integer(preVal));
        }
        preVal = cur.val;
        preDepth = depth;

        if(cur.left != null){
            nodeQueue.add(cur.left);
            depthQueue.add(depth + 1);
        }
        if(cur.right != null) {
            nodeQueue.add(cur.right);
            depthQueue.add(depth + 1);
        }
    }
    rightView.add(preVal);
    return rightView;
}


// depth first search, return right-most values with depth
public List<Integer> rightSideView(TreeNode root) {
    Map<Integer, Integer> rightmostValueAtDepth = new HashMap<Integer, Integer>();
    int max_depth = -1;

    /* These two stacks are always synchronized, providing an implicit
     * association values with the same offset on each stack. */
    Stack<TreeNode> nodeStack = new Stack<TreeNode>();
    Stack<Integer> depthStack = new Stack<Integer>();
    nodeStack.push(root);
    depthStack.push(0);

    while (!nodeStack.isEmpty()) {
        TreeNode node = nodeStack.pop();
        int depth = depthStack.pop();

        if (node != null) {
            max_depth = Math.max(max_depth, depth);

            /* The first node that we encounter at a particular depth contains
             * the correct value. */
            if (!rightmostValueAtDepth.containsKey(depth)) {
                rightmostValueAtDepth.put(depth, node.val);
            }

            nodeStack.push(node.left);
            nodeStack.push(node.right);
            depthStack.push(depth+1);
            depthStack.push(depth+1);
        }
    }

    /* Construct the solution based on the values that we end up with at the
     * end. */
    List<Integer> rightView = new ArrayList<Integer>();
    for (int depth = 0; depth <= max_depth; depth++) {
        rightView.add(rightmostValueAtDepth.get(depth));
    }

    return rightView;
}

// breadth first search,  over-write the last value at each row
public List<Integer> rightSideView(TreeNode root) {
    Map<Integer, Integer> rightmostValueAtDepth = new HashMap<Integer, Integer>();
    int max_depth = -1;

    /* These two Queues are always synchronized, providing an implicit
     * association values with the same offset on each Queue. */
    Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
    Queue<Integer> depthQueue = new LinkedList<Integer>();
    nodeQueue.add(root);
    depthQueue.add(0);

    while (!nodeQueue.isEmpty()) {
        TreeNode node = nodeQueue.remove();
        int depth = depthQueue.remove();

        if (node != null) {
            max_depth = Math.max(max_depth, depth);

            /* The last node that we encounter at a particular depth contains
             * the correct value, so the correct value is never overwritten. */
            rightmostValueAtDepth.put(depth, node.val);

            nodeQueue.add(node.left);
            nodeQueue.add(node.right);
            depthQueue.add(depth+1);
            depthQueue.add(depth+1);
        }
    }

    /* Construct the solution based on the values that we end up with at the
     * end. */
    List<Integer> rightView = new ArrayList<Integer>();
    for (int depth = 0; depth <= max_depth; depth++) {
        rightView.add(rightmostValueAtDepth.get(depth));
    }

    return rightView;
}
