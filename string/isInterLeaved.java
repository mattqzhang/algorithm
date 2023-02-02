/*
InterLeaved Strings
Find if a string is interleaved of two other strings

lc 97
https://leetcode.com/problems/interleaving-string/
*/

// correct solution, but exceeds time limits for complex input
boolean isInterLeave(String A, String B, String C){
    if(A==null && B== null && C==null)
        return true;

    if(A.length() == 0 && B.length() == 0 && C.length() == 0)
        return true;

    // not all of them are empty, then C cannot be empty
    if(C==null || C.length() == 0)
        return false;

    return (C.charAt(0) == A.charAt(0) && isInterLeave(A.substring(1), B, C.substring(1)) ||
            C.charAt(0) == B.charAt(0) && isInterLeave(A, B.substring(1), C.substring(1)));
}

// DP solution

    public static boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();

        if (len1 + len2 != len3) return false;

        // dp[i][j] means to take i chars from s1, and j chars from s2
        // note that dp[0][0] means dont' take any, so there's index shift
        boolean [][] dp = new boolean[len1+1][len2+1];
        dp[0][0] = true;
        // initialize first row and column
        // take 0 from s2
        for (int i=1; i<=len1; i++){
            // if take i from s1, then the index is i-1
            if (s3.charAt(i-1) == s1.charAt(i-1))
                dp[i][0] = dp[i-1][0];
        }

        // take 0 from s1
        for (int i=1; i<=len2; i++){
            if (s3.charAt(i-1) == s2.charAt(i-1))
                dp[0][i] = dp[0][i-1];
        }

        for (int i=1; i<=len1; i++) {
            for (int j=1; j<=len2; j++) {
                int k = i + j -1;
                // if take i from s1, and matches s3:
                if (s3.charAt(k) == s1.charAt(i-1))
                    dp[i][j] = dp[i-1][j];
                // if take j from s2, and matched s3:
                if (s3.charAt(k) == s2.charAt(j-1))
                    dp[i][j] = dp[i][j] || dp[i][j-1];
            }
        }
        return dp[len1][len2];
    }
    public static void main(String[] args) {
        //String s1 = "aabcc";
        String s1 = "a";
        //String s2 = "dbbca";
        String s2 = "";
        //String s3 = "aadbbcbcac";
        String s3 = "a";
        System.out.println(isInterleave(s1, s2, s3));
    }
