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
        Set<Integer> set;
        if(hm.containsKey(nums[i]))
            set = hm.get(nums[i]);
        else
            set = new HashSet<Integer>();
        set.add(i);
        hm.put(nums[i], set);
    }
}

// get a random pick index
public int pick(int target) {
    Set<Integer> set = hm.get(target);
    int[] arr = new int[set.size()];
    int i = 0;
    for(int idx : set){
        arr[i++] = idx;
    }
    Random r = new Random();
    return arr[r.nextInt(arr.length)];
}
