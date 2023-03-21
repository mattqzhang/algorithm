/*
Write a function that takes the binary representation of an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).

lc 191
https://leetcode.com/problems/number-of-1-bits/description/
*/

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ct = 0;
        while (n !=0) {
            if ((n & 1) == 1) ct++;
            n >>>= 1;
        }
        return ct;
    }
