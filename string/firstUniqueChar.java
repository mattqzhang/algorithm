/*
First Unique Character in a String
Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

lc 387
https://leetcode.com/problems/first-unique-character-in-a-string/description/
*/

    public int firstUniqChar(String s) {
        // store the <char, index> map. 
        // if a char appears already, set index to -1
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (hm.containsKey(c)) {
                hm.put(c, -1);
            } else {
                hm.put(c, i);
            }
        }
        // loop through all the values of hm, find the min value/index which is not -1
        int min = Integer.MAX_VALUE;
        for (int v : hm.values()) {
            if (v>0 && v < min)
                min = v;
        }
        if (min != Integer.MAX_VALUE)
            return min;
        return -1;
    }

    // a simpler solution
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (hm.containsKey(c)) {
                hm.put(c, -1);
            } else {
                hm.put(c, i);
            }
        }
        // loop from beginning of string, find first with with index not -1
        for (int i=0; i<s.length(); i++) {
            if (hm.get(s.charAt(i)) >= 0)
                return i;
        }
        return -1;
    }
