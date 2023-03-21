/*
Given two strings s and t, determine if they are isomorphic.
Two strings s and t are isomorphic if the characters in s can be replaced to get t.

lc 205
https://leetcode.com/problems/isomorphic-strings/description/
*/

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Character> s2t = new HashMap<>();
        HashMap<Character, Character> t2s = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (s2t.containsKey(c1)) {
                char map = s2t.get(c1);
                if (map != c2) return false;
            } else {
                s2t.put(c1, c2);
            }

            if (t2s.containsKey(c2)) {
                char map = t2s.get(c2);
                if (map != c1) return false;
            } else {
                t2s.put(c2, c1);
            }
        }
        return true;
    }
