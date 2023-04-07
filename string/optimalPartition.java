/*
Optimal Partition of String
Given a string s, partition the string into one or more substrings such that the characters in each substring are unique. That is, no letter appears in a single substring more than once.

Return the minimum number of substrings in such a partition.

lc 2405
https://leetcode.com/problems/optimal-partition-of-string/
*/

    public int partitionString(String s) {
        if (s.length() == 0) return 0;
        HashSet<Character> hs = new HashSet<>();
        int ct = 1;
        hs.add(s.charAt(0));

        for (int i=1; i<s.length(); i++) {
            // seen the char before, start a new substring
            if (hs.contains(s.charAt(i))) {
                hs = new HashSet<>();
                hs.add(s.charAt(i));
                ct++;
            } else {
                hs.add(s.charAt(i));
            }
        }
        return ct;   
    }
