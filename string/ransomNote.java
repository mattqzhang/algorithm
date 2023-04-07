/*
Ransom Note
Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
Each letter in magazine can only be used once in ransomNote.

lc 383
https://leetcode.com/problems/ransom-note/description/
*/

    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            int ct = hm.getOrDefault(c, 0);
            hm.put(c, ++ct);
        }
        for (char c : ransomNote.toCharArray()) {
            if (!hm.containsKey(c)) return false;
            int ct = hm.get(c);
            if (ct == 0) return false;
            hm.put(c, --ct);
        }
        return true;        
    }
