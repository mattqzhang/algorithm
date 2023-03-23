/*
Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

lc 44
https://leetcode.com/problems/wildcard-matching/description/
*/

// dp solution
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        // 0 is empty, so we need m+1 and n+1
        boolean dp[][] = new boolean[m+1][n+1];
        dp[0][0] = true;

        // if p is something like "**...", first several * should match with empty s
        for (int i=1; i<=n; i++) {
            if (p.charAt(i-1) == '*')
                dp[0][i] = dp[0][i-1];
        }

        for (int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                // same char, or p is '?'
                if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?')
                    dp[i][j] = dp[i-1][j-1];
                // if s[i-1] matches till p[j], then s[i] will also match (as p[j] is '*')
                // if s[i] matches till p[j-1], then s[i] will also match (as p[j] is '*', which is empty here)
                // the dp[i-1][j-1] can actually be ommited here,
                else if (p.charAt(j-1) == '*')
                    dp[i][j] = dp[i-1][j] || dp[i][j-1] || dp[i-1][j-1];
            }
        }
        return dp[m][n];
    }



// this solution times out, when the input is very long
    public boolean isMatch(String s, String p) {
        // compact multiple "*" in p to one "*"
        String t = "";
        boolean prestar = false;
        for (int i=0; i<p.length(); i++) {
            if (p.charAt(i) != '*'){
                prestar = false;
                t += p.charAt(i);
            } else { // is "*"
                if (!prestar) {
                    t += p.charAt(i);
                }
                prestar = true;
            }
        }
        p = t;

        return isMatchRec(s, t);
    }
    public boolean isMatchRec(String s, String p) {
        if (p.length() == 0)
            return s.length() == 0;

        // p only contains "*"
        if (p.equals("*")) return true;

        if (s.length() == 0) return false;

        // first char match
        if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '?')
            return isMatchRec(s.substring(1), p.substring(1));

        // p starts with '*', and at least length 2
        if (p.charAt(0) == '*') {
            // "*" match with empty
            if (isMatchRec(s, p.substring(1))) return true;

            // loop for each possible next match
            int i = 0;
            while (i < s.length()) {
                if (s.charAt(i) == p.charAt(1) || p.charAt(1) == '?')
                    if(isMatchRec(s.substring(i+1), p.substring(2))) return true;
                i++;
            }
        }

        return false;
    }
