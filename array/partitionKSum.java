/*
lc 698
https://leetcode.com/problems/partition-to-k-equal-sum-subsets/

Partition to K Equal Subset Sum
Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into k non-empty subsets whose sums are all equal.
*/

boolean search(int used, int todo, boolean[] memo, int[] nums, int target) {
    if (memo[used] == false) {
        int targ = (todo - 1) % target + 1;
        for (int i = 0; i < nums.length; i++) {
            if ((((used >> i) & 1) == 0) && nums[i] <= targ) {
                if (search(used | (1<<i), todo - nums[i], memo, nums, target)) {
                    memo[used] = true;
                    break;
                }
            }
        }
    }
    return memo[used] == true;
}

public boolean canPartitionKSubsets(int[] nums, int k) {
    int sum = 0;
    for(int val : nums)
        sum += val;
    if (sum % k > 0) return false;

    boolean[] memo = new boolean[1 << nums.length];
    memo[(1 << nums.length) - 1] = true;
    return search(0, sum, memo, nums, sum / k);
}
/** recursive solution */
public boolean search(int[] groups, int ct, int[] nums, int target) {
    if (ct < 0) return true;

    // v is the current largest value, try put it in a group
    // ct--: after you put k, the next starting idx
    int v = nums[ct--];
    for (int i = 0; i < groups.length; i++) {
        if (groups[i] + v <= target) {
            // try put v in group i, and recruviely search with the new ct--
            groups[i] += v;
            if(search(groups, ct, nums, target))
                return true;
            // else v cannot be in group i
            groups[i] -= v;
        }
        if (groups[i] == 0)
            break;
    }
    return false;
}

public boolean canPartitionKSubsets(int[] nums, int k) {
    int sum = Arrays.stream(nums).sum();
    if (sum % k > 0) return false;
    int target = sum / k;

    Arrays.sort(nums);
    int ct = nums.length - 1;
    if (nums[ct] > target) return false;
    // these items equals target, so will be a groups themselves
    while (ct >= 0 && nums[ct] == target) {
        ct--;
        k--;
    }
    return search(new int[k], ct, nums, target);
}
