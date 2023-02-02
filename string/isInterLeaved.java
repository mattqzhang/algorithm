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


