/*
Combine two sorted arrays. 1st has space to hold the content of the 2nd one.
Merge from tail of both arrays and fill in the 1st array, to accommodate the space.

lc 88
https://leetcode.com/problems/merge-sorted-array/description/
*/

// solution 1:
public void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = m-1, j=n-1, idx = n + m - 1;
    while(i>=0 && j>=0){
        if(nums1[i] >= nums2[j]){
            nums1[idx--] = nums1[i--];
        }else{
            nums1[idx--] = nums2[j--];
        }
    }
    while(j>=0){
        nums1[idx--] = nums2[j--];

    }
}

// solution 2:
import java.util.*;

public class arrayCombine {

    /* Combine two sorted arrays, 1st has enough place at the end
     * to accommodate the 2nd one.
     * We merge from tail to fill in the empty spaces first,
     * thus no extra space needed
     */
    static int[] arrayComb(int a[], int b[], int a_end){
        int i = a_end;
        int j = b.length-1;
        int idx = a.length-1;
        while(i>=0 && j>=0){
            if(a[i] > b[j]){
                a[idx] = a[i];       
                i--;
            }else{
                a[idx] = b[j];
                j--;
            }
            idx --;
        }
        // head of b[] is smaller, copy to head of a[]
        if(i<0){
            while(j>=0){
                a[idx] = b[j];
                j--;
                idx --;
            }
        }       
        return a;
    }
   
    public static void main(String[] args) {
        int a[] = new int[7];
        //end index of existing value in a[]
        int a_end = 2;
        a[0] = 3;
        a[1] = 5;
        a[2] = 8;
        int b[] = {2, 6, 7, 9};       
        a = arrayComb(a, b, a_end);
        System.out.println(Arrays.toString(a));
    }

}

