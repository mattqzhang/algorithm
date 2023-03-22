/*
Power of Three
Given an integer n, return true if it is a power of three. Otherwise, return false.
An integer n is a power of three, if there exists an integer x such that n == 3x.

lc 326
https://leetcode.com/problems/power-of-three/description/
*/

    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        
        while (n > 1) {
            if (n % 3 == 0){
                n /= 3;
            } else
                return false;
        }
        // n == 1 here
        return true;     
    }

