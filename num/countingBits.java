/*
Counting Bits
Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.

lc 338
https://leetcode.com/problems/counting-bits/description/
*/


   // classical solution: count 1 for each n

    int getBit(int n) {
        int ct = n & 1;
        while (n > 0) {
            n >>= 1;
            ct += n & 1;
        }
        return ct;
    }

    public int[] countBits(int n) {
        int[] res = new int[n+1];
        res[0] = 0;

        for (int i=1; i<=n; i++) {
            res[i] = getBit(i);
        }
        return res;
    }

   
    // Solution 2: for n, we can re-use the count of n>>1, then add the last bit
 
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        res[0] = 0;
        for (int i = 1; i <= n; i++) {
            res[i] = res[i>>1] + i % 2;
           // can also be:
           //  res[i] = res[i/2] + i % 2;
        }
        return res;
    }

