/*
Given a tree, each node having a weight value. Find the path from root to leaf with the min sum. In a special case, with weight of 1. find the shortest path.

Solution:
- create a hash table for <node, (parent, sum)>,
- do BFS. At each node, record the sum from root to this node. Use a global variable to record the max sum and the corresponding node.
- back trace to root.
At each node we may also record the path from root, but the cost is bigger than construct a parent pointer.
*/


