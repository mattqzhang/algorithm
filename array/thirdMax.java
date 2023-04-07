/*
Third Maximum Number
Given an integer array nums, return the third distinct maximum number in this array. If the third maximum does not exist, return the maximum number.

lc 414
https://leetcode.com/problems/third-maximum-number/description/
*/

    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // used for de-dup
        HashSet<Integer> hs = new HashSet<>();
        
        for (int i=0; i<nums.length; i++) {
            int val = nums[i];
            if (!hs.contains(val)) {  // skip duplicate
                hs.add(val);
                if (pq.size() < 3)
                    pq.add(val);
                else {  // only save top 3 in pq
                    if (val > pq.peek()) {
                        pq.poll();
                        pq.add(val);
                    }
                }
            }
        }
        if (pq.size() == 3) {  // return min
            return pq.poll();
        } else {         // return max
            while (pq.size() > 1)
                pq.poll();
            return pq.poll();
        }
    }

