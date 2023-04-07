/*
Hamming Distance
The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
Given two integers x and y, return the Hamming distance between them.

lc 461
https://leetcode.com/problems/hamming-distance/description/
*/

    public int hammingDistance(int x, int y) {
        int ct = 0;
        while (x > 0 || y > 0) {
            ct += (x & 1) ^ (y & 1);
            x >>= 1;
            y >>= 1;
        }
        return ct;
    }
