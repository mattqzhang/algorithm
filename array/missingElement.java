/*
Missing Elements in Sorted Array
Given a sorted array A of unique numbers, find the K-th missing number starting from the leftmost number of the array.

lc 1060
*/

public int missingElement(int[] nums, int k) {
    int i = 0, remain = k;
    while((i < nums.length -1) && (nums[i] + remain >= nums[i+1])){
        remain = remain - (nums[i+1] - nums[i] - 1);
        i++;
    }
    return nums[i] + remain;
}


/**
 * Binary Search
 **/
// Return how many numbers are missing until nums[idx]
int missing(int idx, int[] nums) {
    return nums[idx] - nums[0] - idx;
}

public int missingElement(int[] nums, int k) {
    int n = nums.length;
    // If kth missing number is larger than the last element of the array
    // it'll be beyond the last element of this array, compute directly.
    if (k > missing(n - 1, nums))
        return nums[n - 1] + k - missing(n - 1, nums);b

    int left = 0, right = n - 1, mid;
    // find left = right index such that missing(left - 1) < k <= missing(left)
    while (left != right) {
        mid = left + (right - left) / 2;

        if (missing(mid, nums) < k)
            left = mid + 1;
        else
            right = mid;
    }

    // kth missing number is larger than nums[idx - 1] and smaller than nums[idx]
    return nums[left - 1] + k - missing(left - 1, nums);
}
