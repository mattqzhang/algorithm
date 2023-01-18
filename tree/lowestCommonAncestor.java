/*
lc 1650

Find Lowest Common Ancestor(LCA) of two given nodes A, B in a binary tree.

With parent pointer:
Solution 1:
- for node A, recursively check it's ancestors, and hash each node.
- for node B, recursively check it's ancestors, till that node is found in the hash table.
Solution 2:
- for node A and B, find the heights h1 and h2.
- suppose h1>h2 (otherwise swap references to the two nodes), computer h = h1 - h2.
- move A up h levels, then trace A and B up simultaneously, until they meet.
*/


// Solution 1: hash parent

public Node lowestCommonAncestor(Node p, Node q) {
    HashSet<Node> hs = new HashSet<>();
    while (p != null) {
        hs.add(p);
        p = p.parent;
    }
    while (q != null) {
        if (hs.contains(q)){
            return q;
        }
        q = q.parent;
    }
    return null;
}


// Solution 2: find level

public Node lowestCommonAncestor(Node p, Node q) {
    int lvl1 = 0;
    int lvl2 = 0;
    Node r = p;
    while (r.parent != null) {
        lvl1++;
        r = r.parent;
    }
    r = q;
    while (r.parent != null) {
        lvl2++;
        r = r.parent;
    }
    // make p higher in the tree
    if (lvl2 < lvl1) {
        r = p;
        p = q;
        q = r;

        int lvl = lvl2;
        lvl2 = lvl1;
        lvl1 = lvl;
    }
    // move q up to the same level as p
    int diff = lvl2 - lvl1;
    while (diff > 0) {
        q = q.parent;
        diff --;
    }
    if (q == p)
        return p;
    else {
        // move both parents up the tree till they meet
        p = p.parent;
        q = q.parent;
        while (p != q) {
            p = p.parent;
            q = q.parent;
        }
        return p;
    }
}

