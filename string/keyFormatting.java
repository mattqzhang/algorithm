/*
License Key Formatting
Given a number K, we would want to reformat the strings such that each group contains exactly K characters, except for the first group which could be shorter than K, but still must contain at least one character. Furthermore, there must be a dash inserted between two groups and all lowercase letters should be converted to uppercase.

Input: s = "5F3Z-2e-9-w", k = 4
Output: "5F3Z-2E9W"

Input: s = "2-5g-3-J", k = 2
Output: "2-5G-3J"

lc 482
https://leetcode.com/problems/license-key-formatting/
*/

public String licenseKeyFormatting(String S, int K) {
    // remove all existing "-"
    S = S.toUpperCase();
    S = S.replace("-","");
    String res = "";

    // get size of first group
    int n = S.length();
    int firstSize = n % K;

    if(firstSize > 0) {
        res += S.substring(0, firstSize);
        if(firstSize < n)
            res += '-';
    }

    // add each (i, i+K) group
    int i = firstSize;
    while(i+K <= S.length()){
        res += S.substring(i, i+K);
        if(i+K < S.length())
            res += '-';
        i += K;
    }

    return res;
}
