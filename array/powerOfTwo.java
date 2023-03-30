/*
Given an integer n, return true if it is a power of two. Otherwise, return false.

An integer n is a power of two, if there exists an integer x such that n == 2x.


lc 231
https://leetcode.com/problems/power-of-two/description/
*/

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        
        while (n > 0) {
            if (n == 1) return true;
            if (n % 2 == 1) return false;
            n = n/2;
        }
        return true;
    }
