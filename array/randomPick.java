/*
Random Pick Index
Given an array of integers with possible duplicates, randomly output the index of a given target number. You can assume that the given target number must exist in the array.
*/

// data structure to save the array
// hashmap with <number, set of indices>
HashMap<int, Set<Integer>> hm;

// initialize the hashmap
public randomPick(int[] nums) {
    for(int i=0; i<nums.length; i++){
        Set<Integer> set = hm.getOrDefault(nums[i], new HashSet<Integer>());
        set.add(i);
        hm.put(nums[i], set);
    }
}

// get a random pick index
public int pick(int target) {
    Set<Integer> set = hm.get(target);
    int size = set.size;
    int choice = new Random().nextInt(size);
    int ct = 0;

    for(Integer obj : set){
       if (ct == choice)
         return obj.intValue();
       ct ++;
    }
}
