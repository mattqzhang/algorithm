/*
search for a value x in a sorted and rotated array
If the current array is already in order, apply bSearh() recursively.
Else find the mid value, and identify the subarray x belongs to, then depending on whether it's in order, apply rotateSearch() or bSearch() recursively.

lc 33
https://leetcode.com/problems/search-in-rotated-sorted-array/description/
*/

// solution 1: no recursive call, use while loop:

public int search(int[] nums, int target) {
    int start = 0, end = nums.length - 1;
    while (start <= end) {
        int mid = start + (end - start) / 2;
        if (nums[mid] == target)
            return mid;

        // sorted in [start, mid]
        else if (nums[mid] >= nums[start]) {
            // in the sorted part
            if (target >= nums[start] && target < nums[mid])
                end = mid - 1;
            else
                start = mid + 1;
        } // rotate within [start, mid]
        else {
            if (target <= nums[end] && target > nums[mid])
                start = mid + 1;
            else end = mid - 1;
        }
    }
    return -1;
}

// solution 2: recursive call

/*
 * Search for a value in a sorted and rotated array
 *
 * Author: Qing "Matt" Zhang
 * https://sites.google.com/site/mattzhangcube/home/coding
 */

public class rotateSearch {

    public static int rotSearch(int a[], int start, int end, int x){
        int idx = -1;
        
        // 1 or 2 values
        if ((start == end)||(start==end-1)){
            if(x == a[start])
                idx = start;
            if(x == a[end])
                idx = end;
            return idx;
        }
       
        // start < end, fully sorted
        if(a[start] < a[end]){
            idx = bSearch(a, start, end, x);
            return idx;
        }
       
        int mid = (start + end)/2;
       
        // there are 2 different cases for mid when start > end
        //    in the sorted part, or rotated part
        if(x >= a[start] && x <= a[mid]){
            idx = bSearch(a, start, mid, x);
            return idx;
        }
        else if(x >= a[mid] && x <= a[end]){
            idx = bSearch(a, mid, end, x);
            return idx;
        }
        // the two cases are in the rotated part
        else if(a[mid] > a[end]){
            idx = rotSearch(a, mid, end, x);
            return idx;
        }else{
            idx = rotSearch(a, start, mid, x);
            return idx;
        }                           
    }
   
    public static int bSearch(int a[], int start, int end, int x){
        int idx = -1;
       
        if(start>end)
            return idx;       
       
        int mid = (start +end)/2;       
       
        if(a[mid] == x)
            return mid;
        else if(a[mid] > x)
            return bSearch(a, start, mid-1, x);
        else
            return bSearch(a, mid+1, end, x);               
    }
   
    public static final int arr[] = {7, 8, 9, 10, 1, 2, 3, 4, 5, 6};
   
    public static void main(String[] args) {
        int testvals[] = {-1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        for(int i=0; i<testvals.length; i++)
            System.out.println("index of " + testvals[i] + " is " + rotSearch(arr, 0, arr.length-1, testvals[i]));           
    }
}

