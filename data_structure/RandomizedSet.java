/*
Insert, Delete, GetRamdon at O(1)
Design a data structure that supports all following operations in average O(1) time.
insert(val): Inserts an item val to the set if not already present.
remove(val): Removes an item val from the set if present.
getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
*/

// to support remove(val) in O(1), need some hash mechanism to find the location of the value
// to support O(1) getRandom(), we can think of an arrary, return a random index

// data -> index
HashMap<Integer, Integer> hm;
// data store
ArrayList<Integer> arrList;

/** Initialize your data structure here. */
public RandomizedSet() {
    hm = new HashMap<>();
    arrList = new ArrayList<>();
}

/** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
public boolean insert(int val) {
    if(hm.containsKey(val))
        return false;

    arrList.add(val);
    hm.put(val, arrList.size() -1 );
    return true;
}

/** Removes a value from the set. Returns true if the set contained the specified element. */
public boolean remove(int val) {
    if(!hm.containsKey(val))
        return false;

    int idx = hm.get(val);

    // swap with last one
    int lastIdx = arrList.size() - 1;
    int lastVal = arrList.get(lastIdx);
    arrList.set(idx, lastVal);
    hm.put(lastVal, idx);

    // delete last one
    arrList.remove(arrList.size() - 1);
    hm.remove(val);

    return true;
}

/** Get a random element from the set. */
public int getRandom() {
    int idx =  new Random().nextInt(arrList.size());
    return arrList.get(idx);
}
