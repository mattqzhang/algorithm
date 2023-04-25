/*
Maximum Width of Binary Tree
Given the root of a binary tree, return the maximum width of the given tree.

The maximum width of a tree is the maximum width among all levels.

lc 662
https://leetcode.com/problems/maximum-width-of-binary-tree/description/
*/

    class Node {
        TreeNode node;
        int index;
        public Node(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    // create node index according to the full complete binary tree
    // i.e. each node's child is 2i+1 and 2i+2
    // Then despite the missing node, the end node's index at each row will account for the missing ones.
    // Then we only need the start and end index of each row, to get the width..
   
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<Node> qe = new LinkedList<>();
        int start = 0, end = 0, max = 0;
        qe.offer(new Node(root, 0));

        while (!qe.isEmpty()) {
            int size = qe.size();
            start = qe.peek().index;

            // go through all nodes at this level
            for (int i=0; i<size; i++) {
                Node cur = qe.poll();
                TreeNode tnode = cur.node;
                int index = cur.index;
                end = index;
                if (tnode.left != null) {
                    qe.offer(new Node(tnode.left, 2*index + 1));
                }
                if (tnode.right != null) {
                    qe.offer(new Node(tnode.right, 2*index + 2));
                }
            }
            max = (end - start + 1) > max ? (end - start + 1) : max;
        }
        return max;
    }
