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
