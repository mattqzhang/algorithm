/*
Is Subsequence
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

lc 392
https://leetcode.com/problems/is-subsequence/description/
*/

    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        if (t.length() < s.length()) return false;
        
        int i=0, j=0;
        while (i<s.length() && j<t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
                if (i == s.length()) return true;
            } else
                j++;
        }
        return false;        
    }
