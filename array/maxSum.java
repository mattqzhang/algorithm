/*
Maximum continuous subset sum problem: Given an array, find the maximum sum of continuous subset.
Go through the array, and compute the current sum:
- if it's bigger than the maxSum, update global max, start, end
- If the subset sum < 0 at some time, this cannot be a solution when concatenating with future data. Reset next block for a new start.
*/

// solution 1: only print max

public int maxSubArray(int[] nums) {
    int max = nums[0];
    int sum = max;

    for(int i=1; i<nums.length; i++){
        sum = Math.max(sum + nums[i], nums[i]);
        max = Math.max(max, sum);
    }
    return max;
}

// solution 2: keep record of start and end index

/*
 * Given an array, find the maximum sum of continuous subset.
 *
 * Author: Qing "Matt" Zhang
 * https://sites.google.com/site/mattzhangcube/home/coding
 */
/* given an array, find the maximum sum of continuous subset.
 */

public class maxSum {
    public static void maxSubSum(int a[]){
        int maxSum = 0;       
        int maxstart = 0, maxend = 0;
       
        int sum = 0;
        int start = 0, end = 0;
       
        for (int i=0; i<a.length; i++){
            sum += a[i];
            end =i;
            if(sum > maxSum){
                maxSum = sum;
                maxstart = start;
                maxend = end;
            }
            if(sum <= 0){
                sum = 0;
                start = i+1;
                end = i+1;
            }
        }
        System.out.println("max sum is: " + maxSum + ", starting from " + maxstart +
                " and ending at " + maxend);
    }
   
   
    public static void main(String[] args) {
        int[] a = {1, 2, -1, -3, 5, 7, 1, 0, -2, 12, 8, 0, -3, 15};
        //int[] a = { -1, -2, 5, -2, 1, 2, -6, 2, 1 };
        //int[] a = { 3, -2, 5, -2, -4,};

        maxSubSum(a);       
    }
}
