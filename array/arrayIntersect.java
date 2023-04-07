/*
Find the intersection of two sorted arrays a[m] and b[n]
Solution 1: use two pointers to iterate through the two arrays, O(m + n)
Solution 2: use hash table to hash b, and search each a, O(m+n)
Solution 3: if m<<n, binary search each a in b, O(mlgn).
                  Note: since a is ordered, we can decrease the binary search range for each value in a. (left side start from the last index)

More complicate:
Intersection of two arrays(unsorted and may have duplicates)

lc 349
https://leetcode.com/problems/intersection-of-two-arrays/description/
*/

public int[] intersection(int[] nums1, int[] nums2) {
    HashSet<Integer> hs = new HashSet<Integer>();
    HashSet<Integer> res = new HashSet<>();

    for(int i=0; i<nums1.length; i++)
        hs.add(nums1[i]);

    for(int j=0; j<nums2.length; j++){
        if(hs.contains(nums2[j]))
            res.add(nums2[j]);
    }

    int output[] = new int[res.size()];
    int i = 0;
    for(int val : res){
        output[i] = val;
        i++;
    }

    return output;
}
