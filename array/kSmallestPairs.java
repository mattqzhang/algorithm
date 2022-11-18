/*
lc 373
https://leetcode.com/problems/find-k-pairs-with-smallest-sums/

Find K Pairs with Smallest Sum
You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
*/

public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    List<List<Integer>> res = new LinkedList<>();
    if(nums1==null || nums1.length==0 || nums2==null || nums2.length==0) {
        return res;
    }

    PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
        @Override
        public int compare(int[] arr1, int[] arr2) {
            return arr1[2]-arr2[2];
        }
    });
    for(int i=0; i<nums1.length && i < k; i++) {
        for(int j=0; j<nums2.length && j<k; j++) {
            pq.offer(new int[]{nums1[i], nums2[j], nums1[i] + nums2[j]});
        }
    }

    while(k>0 && !pq.isEmpty()) {
        int[] curr = pq.poll();
        res.add(Arrays.asList(new Integer[]{curr[0], curr[1]}));
        k--;
    }
    return res;
}
