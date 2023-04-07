/*
Median of Two Sorted Arrays
Solution 1: use two pointers to iterate through the two arrays in k steps
Solution 2: binary search for the k-th element
https://www.geeksforgeeks.org/median-two-sorted-arrays-different-sizes-ologminn-m/

lc 4
https://leetcode.com/problems/median-of-two-sorted-arrays/description/
*/

// binary search:

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if ((m+n)%2 == 0) {
            return (findKth(nums1, nums2, 0, 0, (m+n)/2) + 
                   findKth(nums1, nums2, 0, 0, (m+n)/2+1))/2.0;
        } else {
            return findKth(nums1, nums2, 0, 0, (m+n+1)/2);
        }
    }

    //find kth large number
    private int findKth(int[] nums1, int[] nums2, int startA, int startB, int k) { 
        // run out of one array
        if (startA >= nums1.length) return nums2[startB+k-1];
        if (startB >= nums2.length) return nums1[startA+k-1];
        
        if (k == 1) {
            return Math.min(nums1[startA], nums2[startB]);
        }
        
        // mid points of each array to k
        int midA = startA + k/2 -1 >= nums1.length ? Integer.MAX_VALUE : nums1[startA + k/2 - 1];
        int midB = startB + k/2 -1 >= nums2.length ? Integer.MAX_VALUE : nums2[startB + k/2 - 1];
        
        // left k/2 part of B can be throw away
        if (midA > midB) {
            return findKth(nums1, nums2, startA, startB + k/2, k - k/2);
        }
        // throw away right k/2 part
        return findKth(nums1, nums2, startA + k/2, startB, k - k/2);
    }


// two pointers to loop each array

    // find by counting and merging the arrays, O(N)
    // for total odd numbers, medium is the value at (n/2 +1)
    // for total even numbers, medium is the avg of (n/2) and (n/2+1)
    static float ctMedium(int a[], int b[]){
        assert(a.length>0 && b.length >0);
       
        int n = a.length + b.length;
        boolean odd = true;       
        if(n%2 ==0)   
            odd = false;       
   
        float medium = 0;
        int current = 0;
       
        int i=0, j=0;
        while(i<a.length && j<b.length && (i+j) < n/2){
            if(a[i] < b[j]){
                i++;               
            }
            else{               
                j++;
            }
        }
       
        while(i==a.length && (i+j) <n/2){
            current = b[j];
            j++;
        }
        while(j==a.length && (i+j) <n/2){
            current = a[i];
            i++;
        }
       
        // now we're at i+j = n/2 point
        // we need the next one at (n/2+1) for computation of medium
        int next;
        if(i==a.length)  // i is already out of range
            next = b[j];
        else if (j == b.length)    // j is already out of range
            next = a[i];
        else        // next smallest one
            next = a[i]<b[j]? a[i] : b[j];
       
        if(odd){    //next value at (n/2+1) is medium
            medium = next;
        }else{        // avg of current n/2 and next (n/2+1) is medium
            medium = (float)(current + next)/2;
        }
       
        return medium;
    }
   
