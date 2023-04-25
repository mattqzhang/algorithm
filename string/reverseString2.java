/*
Reverse String II
Given a string s and an integer k, reverse the first k characters for every 2k characters counting from the start of the string.

If there are fewer than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and leave the other as original.

lc 541
https://leetcode.com/problems/reverse-string-ii/description/
*/

    public String reverseStr(String s, int k) {
        int n = s.length();
        if (n < 2) return s;

        String res = "";
        for (int start =0; start < n; start += 2*k) {
            for (int i = Math.min(start+k-1, n-1); i >= start; i--) {
                res += s.charAt(i);
            }
            
            for (int i = start +k; (i < start + k*2) && i < n; i++) {
                res += s.charAt(i);
            }
        }
        return res;    
    }
