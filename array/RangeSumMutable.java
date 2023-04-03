/*
Range Sum Query - Mutable
Given an integer array nums, handle multiple queries of the following types:
Update the value of an element in nums.
Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.

lc 307
https://leetcode.com/problems/range-sum-query-mutable/description/
*/

// Solution 1: 
// it times out with large inputs

class NumArray {

    int[] sum;
    int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
        sum = new int[nums.length + 1];
        sum[0] = 0;
        for(int i=0; i<nums.length; i++)
            sum[i+1] = sum[i] + nums[i];
    }

    public void update(int index, int val) {
        int tmp = nums[index];
        nums[index] = val;
        for (int i=index + 1; i<sum.length; i++) {
            sum[i] = sum[i] - tmp + val;
        }
    }

    public int sumRange(int left, int right) {
        return sum[right + 1] - sum[left];
    }
}


// solution 2: Segment Tree

class NumArray {
    int[] tree;
    int n;

    public NumArray(int[] nums) {
        if (nums.length > 0) {
            n = nums.length;
            tree = new int[n * 2];
            buildTree(nums);
        }
    }

    private void buildTree(int[] nums) {
        for (int i = n, j = 0; i < 2 * n; i++, j++)
            tree[i] = nums[j];
        for (int i = n - 1; i > 0; --i)
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
    }

    void update(int pos, int val) {
        pos += n;
        tree[pos] = val;
        while (pos > 0) {
            int left = pos;
            int right = pos;
            if (pos % 2 == 0) {
                right = pos + 1;
            } else {
                left = pos - 1;
            }
            // parent is updated after child is updated
            tree[pos / 2] = tree[left] + tree[right];
            pos /= 2;
        }
    }

    public int sumRange(int l, int r) {
        // get leaf with value 'l'
        l += n;
        // get leaf with value 'r'
        r += n;
        int sum = 0;
        while (l <= r) {
            if ((l % 2) == 1) {
                sum += tree[l];
                l++;
            }
            if ((r % 2) == 0) {
                sum += tree[r];
                r--;
            }
            l /= 2;
            r /= 2;
        }
        return sum;
    }
}




