/*
Populating Next Right Pointers in Each Node
lc 116
https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/

You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. 
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
*/
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }
}


// solution 1: recursive call

    public Node connect(Node root) {
        if (root == null) return null;

        if (root.left != null)
            root.left.next = root.right;
        if (root.right != null) {
            // note: this only works for PERFECT binary tree
            if (root.next != null)
                root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
        return root;        
    }

// solution 2: non-recursive, start from head of each level

    public Node connect(Node root) {
        if (root == null) return null;

        Node levelHead = root;
        while (levelHead != null) {
            Node cur = levelHead;
            while (cur != null) {
                if (cur.left != null) {
                    cur.left.next = cur.right;
                }
                if (cur.right != null) {
                    if (cur.next != null) {
                        cur.right.next = cur.next.left;
                    }
                }
                cur = cur.next;
            }
            levelHead = levelHead.left;
        }
        return root;
    }


// Solution 3: use queue to process level by level:

    public Node connect(Node root) {
        if (root == null) return null;

        Queue<Node> qe = new LinkedList<>();
        qe.add(root);
        qe.add(new Node(-1001));  // level breaker
        Node pre = new Node(-1002);  // a dummy head for each level

        while (!qe.isEmpty()) {
            Node cur = qe.remove();
            if (cur.val != -1001) {  // not a level breaker
                pre.next = cur;
                pre = cur;
                if (cur.left != null)
                    qe.add(cur.left);
                if (cur.right != null)
                    qe.add(cur.right);
            } else {          // level breaker;
                pre.next = null;
                if (!qe.isEmpty()) {
                    qe.add(new Node(-1001));  // add a new level breaker;
                    pre = new Node(-1002);    // start the next dummy head
                }
            }
        }
        return root;
    }

