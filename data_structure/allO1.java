/*
All O(1) Data Structure
Implement a data structure supporting the following operations in O(1):

Inc(Key) - Inserts a new key with value 1. Or increments an existing key by 1. Key is guaranteed to be a non-empty string.
Dec(Key) - If Key's value is 1, remove it from the data structure. Otherwise decrements an existing key by 1. If the key does not exist, this function does nothing. Key is guaranteed to be a non-empty string.
GetMaxKey() - Returns one of the keys with maximal value. If no element exists, return an empty string "".
GetMinKey() - Returns one of the keys with minimal value. If no element exists, return an empty string "".
*/


// to support Inc/Dec in O(1), we need a HashMap of keys
// to support GetMax/GetMin in O(1), we need a TreeMap of <values, key/node>


// use double linked list here to store count and the string key.
class DLNode{
    DLNode next, prev;
    int ct;
    String key;
    public DLNode(String key){
        this.key = key;
    }
}
// val --> DL node
private TreeMap<Integer, DLNode> tm;
// key --> DL node
private HashMap<String, DLNode> hm;

/** Initialize your data structure here. */
public AllOne() {
    tm = new TreeMap<Integer, DLNode>();
    hm = new HashMap<String, DLNode>();
}

// setup TreeMap, and DL node link
private void add(DLNode loc, int val){
    if(tm.containsKey(val)){ //has this count
        DLNode currentLoc = tm.get(val);
        currentLoc.prev = loc;
        loc.next = currentLoc;
    }
    tm.put(val, loc);
}

private void remove(DLNode loc, int val){
    if(loc.prev == null){  // the first one in this treemap entry
        if(loc.next == null){ // the only one in this treemap entry
            tm.remove(val);
        }else{
            tm.put(val, loc.next);
            loc.next.prev = null; //delink next
        }
    }else{ // not the first one
        loc.prev.next = loc.next; // link previous with next
    }

    loc.prev = null;
    loc.next = null;
}
/** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
public void inc(String key) {
    int currentCt = 0;
    if(!hm.containsKey(key)){//first time
        hm.put(key, new DLNode(key));
    }else{// not first time
        currentCt = hm.get(key).ct;
        remove(hm.get(key), currentCt);
    }
    hm.get(key).ct = currentCt + 1;
    // setup TreeMap, and DL node link
    add(hm.get(key), currentCt + 1);

}

/** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
public void dec(String key) {
    int currentCount = 0;
    if(hm.containsKey(key))
        currentCount = hm.get(key).ct;
    if(currentCount > 0){
        remove(hm.get(key), currentCount);
        add(hm.get(key), currentCount-1);
        hm.get(key).ct= currentCount-1;
    }
}

/** Returns one of the keys with maximal value. */
public String getMaxKey() {
    if(tm.size()==0)
        return "";
    int maxVal = tm.lastKey();
    if(maxVal==0)
        return "";
    return tm.get(maxVal).key;
}

/** Returns one of the keys with Minimal value. */
public String getMinKey() {
    if(tm.size()==0)
        return "";
    Integer minLevel = tm.ceilingKey(1);
    if(minLevel==null)
        return "";
    return tm.get(minLevel).key;
}
