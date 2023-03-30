/*
Given a pattern and a string s, find if s follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.


lc 290
https://leetcode.com/problems/word-pattern/description/
*/

    public boolean wordPattern(String pattern, String s) {
        String[] tokens = s.split("\\s+");
        if (pattern.length() != tokens.length) return false;
                
        HashMap<Character, String> hm = new HashMap<>();
        for (int i=0; i<pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (hm.containsKey(c)) {
                if (!hm.get(c).equals(tokens[i]))
                    return false;
            } else { // not contain c in pattern, then shouldn't contain the value in s too
                if (hm.containsValue(tokens[i]))
                    return false;
                hm.put(c, tokens[i]);
            }
        }
        return true;
    }
