/*  
lc 34
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/

Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
*/

public class RangeSort {

    public int findEdge(int[] nums, int target, boolean left){
        int len = nums.length;

        int lo = 0, hi = len-1;
        while(lo <= hi) {
            int mid = (lo + hi)/2;
            if(nums[mid] == target) {
                if(left) {
                    if (mid ==0 || nums[mid-1] < nums[mid])
                        return mid;
                    else
                        hi = mid - 1;
                } else {// right
                    if (mid == len-1 || nums[mid] < nums[mid + 1])
                        return mid;
                    else
                        lo = mid + 1;
                }
            }
            else if (nums[mid] > target)
                hi = mid - 1;
            else
                lo = mid + 1;
        }
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] range = new int[]{-1, -1};
        if(nums == null || nums.length == 0)
            return range;

        // left edge
        range[0] = findEdge(nums, target, true);
        if(range[0] == -1)
            return range;

        // left found, now search for right
        range[1] = findEdge(nums, target, false);

        return range;
    }


    public static void main(String[] args){
        int nums[] = new int[]{1, 2, 5, 5, 5, 6, 7};
        //int nums[] = new int[]{1};
        int target = 7;
        int range[] = new RangeSort().searchRange(nums, target);
        System.out.println(range[0] + ", " + range[1]);

        System.out.println("\ndone ");
    }
}
