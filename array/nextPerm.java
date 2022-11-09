/*
lc 31
https://leetcode.com/problems/next-permutation/

Next Permutation
 rearranges numbers into the lexicographically next greater permutation of numbers.
*/

private static void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}

private static void reverse(int[] nums, int start) {
    int i = start, j = nums.length - 1;
    while (i < j) {
        swap(nums, i, j);
        i++;
        j--;
    }
}
public static void nextPermutation(int[] nums) {
    int len = nums.length;
    int i = len -1;
    while(i>0 && nums[i] <= nums[i-1])
        i--;

    // find j to swap
    if(i>0){
        // (i-1, j) is the first increasing sequence
        int j = nums.length -1;
        while(nums[j] <= nums[i-1])
            j--;
        swap(nums, i-1, j);
    }

    //reverse from i to len-1
    reverse(nums, i);
    for(i=0; i<nums.length; i++)
        System.out.print(nums[i] + " ");
}
