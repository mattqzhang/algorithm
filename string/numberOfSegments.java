/*
Number of Segments in a String
Given a string s, return the number of segments in the string.
A segment is defined to be a contiguous sequence of non-space characters.

lc 434
https://leetcode.com/problems/number-of-segments-in-a-string/description/
*/

// using split function
    public int countSegments(String s) {
        s = s.trim();
        if (s.length() == 0) return 0;
        return s.split("\\s+").length;
    }


// step through each char
    public int countSegments(String s) {
        s = s.trim();
        if (s.length() == 0) return 0;
        
        int ct = 0;
        for (int i=1; i<s.length(); i++) {
            if (s.charAt(i) == ' ' && s.charAt(i-1) != ' ')
                ct++;
        }
        // add last word
        return ++ct;
    }
