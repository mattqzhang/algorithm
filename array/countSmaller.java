/*
lc 315
https://leetcode.com/problems/count-of-smaller-numbers-after-self/
https://zxi.mytechroad.com/blog/algorithms/array/leetcode-315-count-of-smaller-numbers-after-self/

Count of Smaller Numbers After Self
You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
*/

class Node {
    int val;
    int count; // same value
    int left_count; // values smaller than the current node (on left subtree)
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
        this.count = 1;
    }

    public int less_or_equal() {
        return count + left_count;
    }
}

public List<Integer> countSmaller(int[] nums) {
    List<Integer> ans = new ArrayList<>();
    if (nums.length == 0)
        return ans;

    int n = nums.length;
    Node root = new Node(nums[n - 1]);
    ans.add(0);
    for (int i = n - 2; i >= 0; --i)
        ans.add(insert(root, nums[i]));
    Collections.reverse(ans);
    return ans;
}

private int insert(Node curr, int val) {
    // val same as the current node, so current node's left child are all the counts
    if (curr.val == val) {
        ++curr.count;
        return curr.left_count;
    } // on the left tree, increase current node's left count
    else if (val < curr.val) {
        ++curr.left_count;
        if (curr.left == null) {
            curr.left = new Node(val);
            return 0;
        }
        return insert(curr.left, val);
    } // on the right tree, current node, and all it's left children, are included in the count
    else  {
        if (curr.right == null) {
            curr.right = new Node(val);
            return curr.less_or_equal();
        }
        return curr.less_or_equal() + insert(curr.right, val);
    }
}
