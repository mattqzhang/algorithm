/*
Power of Four
Given an integer n, return true if it is a power of four. Otherwise, return false.

lc 342
https://leetcode.com/problems/power-of-four/description/
*/

    public boolean isPowerOfFour(int n) {
        if (n <=0) return false;        
        while (n >0) {
            if (n == 1) return true;
            if (n % 4 != 0) return false;
            n = n/4;
        }
        return true;
    }
