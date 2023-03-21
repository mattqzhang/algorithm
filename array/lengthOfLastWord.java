/*
Given a string s consisting of words and spaces, return the length of the last word in the string.

lc 58
https://leetcode.com/problems/length-of-last-word/description/
*/

    // use java string functions
    public int lengthOfLastWord(String s) {
        s = s.trim();
        String[] words = s.split("\\s+");
        int n = words.length;
        return words[n].length();
    }

    // don't use any string function
    public int lengthOfLastWord_v2(String s) {
        int n = s.length();
        int end = n-1;
        // check backword, find the last non whitespace idx
        while (end >=0 && s.charAt(end) == ' ')
            end--;
        // all whitespaces
        if (end < 0) return 0;

        // backword, find the beginning of the last word
        int start = end;
        while(start >=0 && s.charAt(start) != ' ') {
            start --;
        }
        return end - start;
    }
