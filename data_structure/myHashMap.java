/*
Design HashMap

lc 706
https://leetcode.com/problems/design-hashmap/description/
*/

class MyHashMap {
    int[] values;
    /** Initialize your data structure here. */
    public MyHashMap() {
        values = new int[1000000];
        Arrays.fill(values, -1);
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        values[key] = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return values[key];
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        values[key] = -1;
    }
}



// a general solution

/*
Implement a HashMap
Implement the function get(), put(), remove()
*/

public class myHashMap<K, V>{
    private class Item<K, V> {
        K key;
        V value;
        Item next;

        Item(K key, V value) {
            this.key = key;
            this.value = value;
            next = null;
        }
    }

    Item<K, V>[] map;
    static final int MAXSIZE = 128;

    myHashMap(){
        map = new Item[MAXSIZE];
    }

    void put(K key, V value){
        // get index into map array
        int hashcode = key.hashCode();
        int idx = hashcode % map.length;
        Item entry = map[idx];
        while(entry != null){
            if(entry.key  == key ){
                // update existing value
                entry.value = value;
                return;
            }
            entry = entry = entry.next;
        }
        // put new item as head of the map entry
        Item newEntry = new Item(key, value);
        newEntry.next = map[idx];
        map[idx] = newEntry;
    }

    V get(K key){
        int hashcode = key.hashCode();
        int idx = hashcode % map.length;
        Item<K, V> entry = map[idx];
        while (entry == null){
            if(key == entry.key){
                return entry.value;
            }else
                entry = entry.next;
        }
        return null;
    }

    boolean remove(K key){
        int hashcode = key.hashCode();
        int idx = hashcode % map.length;
        Item pre = null;

        Item<K, V> entry = map[idx];
        while(entry != null){
            if(key == entry.key){
                if(pre == null)
                    map[idx] = entry.next;
                else{
                    pre.next = entry.next;
                }
                return true;
            }
            pre = entry;
            entry = entry.next;
        }
        return false;
    }
}
