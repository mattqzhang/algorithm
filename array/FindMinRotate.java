/*
Rotate search for the start of the array / min value of array
*/

public int findMin(int[] nums) {
    if (nums.length == 1) {
        return nums[0];
    }

    int start = 0, end = nums.length - 1;
    // Binary search
    while (start <= end) {
        if (nums[end] > nums[start]) {
            return nums[start];
        }

        int mid = (start + end) / 2;

        if (nums[mid] > nums[mid + 1]) {
            return nums[mid + 1];
        }

        if (nums[mid - 1] > nums[mid]) {
            return nums[mid];
        }

        if (nums[mid] > nums[start]) {
            start = mid + 1;
        } else {
            end = mid - 1;
        }
    }
    return start;
}
