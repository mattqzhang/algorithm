/*
Longest Palindrome
Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.
Letters are case sensitive, for example, "Aa" is not considered a palindrome here.

lc 409
https://leetcode.com/problems/longest-palindrome/description/
*/

    public int longestPalindrome(String s) {
        int n = s.length();
        if (n<=1) return n;
        
        // put each char in a hashset.
        // if we find a pair, then remove it and increase ct by 2
        HashSet<Character> hs = new HashSet<>();
        int ct = 0;
        for (int i=0; i<n; i++) {
            if (!hs.contains(s.charAt(i))) {
                hs.add(s.charAt(i));
            } else {
                hs.remove(s.charAt(i));
                ct += 2;
            }
        }
        // a single one can be added in the middle.
        if (!hs.isEmpty()) ct++;
        return ct;
    }
