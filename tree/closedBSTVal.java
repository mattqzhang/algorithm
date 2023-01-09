/*
Closet k BST Value
Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.
*/

public List<Integer> closestKValues(TreeNode root, double target, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            // customize it to be a max queue
            return Double.compare(Math.abs(target - o2), Math.abs(target - o1));
        }
    });

    search(pq, root, target, k);
    return new LinkedList(pq);
}
public void search(PriorityQueue<Integer> pq, TreeNode root, double target, int k) {
    if(root == null)
        return;
    if(pq.size() < k)
        pq.offer(root.val);
    else {
        // closer than existing K values
        if(Math.abs(target - root.val) < Math.abs(target - pq.peek())) {
            pq.offer(root.val);
            pq.poll();
        }
    }
    search(pq, root.left, target, k);
    search(pq, root.right, target, k);
}
