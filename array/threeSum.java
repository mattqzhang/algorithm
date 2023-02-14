/*
Three Sum problem: Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

lc 15
https://leetcode.com/problems/3sum/description/
*/

public static List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);

    // <value, index> mapping
    HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
    for(int i=0; i<nums.length; i++){
        hm.put(nums[i], i);
    }
    List<List<Integer>> output = new LinkedList<List<Integer>>();

    // remove duplicate, as we may have same value appear multiple times.
    HashSet<List<Integer>> findHm = new HashSet<List<Integer>>();

    for(int i=0; i< nums.length; i++){
        for(int j=i+1; j<nums.length; j++){
            int sum = nums[i] + nums[j];
            Integer Idx = hm.get(0-sum);
            if(Idx != null) {
                int idx = Idx.intValue();
                if (idx > i && idx > j) {
                    List<Integer> findOne = new LinkedList<Integer>();
                    findOne.add(nums[i]);
                    findOne.add(nums[j]);
                    findOne.add(nums[idx]);

                    // detect duplicate, as we may have some values appear multiple times
                    if(!findHm.contains(findOne)) {
                        findHm.add(findOne);
                        output.add(findOne);
                    }
                }
            }
        }
    }
    return output;
}
