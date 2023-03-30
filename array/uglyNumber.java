/*

An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.

Given an integer n, return true if n is an ugly number.

lc 263
https://leetcode.com/problems/ugly-number/description/
*/

    public boolean isUgly(int n) {
        if (n<=0) return false;
        if (n == 1) return true;

        while (n > 1) {
            if (n % 2 == 0)
                n /= 2;
            else if (n % 3 == 0)
                n /= 3;
            else if (n % 5 == 0)
                n /= 5;
            else return false;
        }
        return true;        
    }
