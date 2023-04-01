/*
 * Binary Search in a sorted arrary
 *
 * lc 704
 * https://leetcode.com/problems/binary-search/description/ 
*/

// recursive solution
    int bSearch(int[] nums, int target, int start, int end) {
        if (start > end) return -1;
        
        int mid = (start + end)/2;
        if (target == nums[mid]) return mid;
        
        if (target > nums[mid])
            return bSearch(nums, target, mid+1, end);
        else
            return bSearch(nums, target, start, mid-1);
    }

    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;

        return bSearch(nums, target, 0, nums.length-1);
    }

// non-recursive solution
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;

        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }


// old solution

public class bSearch {

    private static int bsearch(int a[], int start, int end, int x){
        if(start>end)
            return -1;
        //since a[] is sorted, you can also return a[0]-1 or a[len-1] +1
       
        int mid;
        int len = end - start +1;
        mid = start + (int)len/2;       
       
        if(a[mid] == x)
            return mid;
        else if(a[mid] > x)
            return bsearch(a, start, mid-1, x);
        else
            return bsearch(a, mid+1, end, x);
    }
   
    public static void main(String[] args) {
        int a[] = {0, 1,2,3,4};
        for(int x = -3; x < a.length+2; x++){
            int idx = bsearch(a, 0, a.length-1, x);
            System.out.println("idx =" + idx);
        }
    }
}
