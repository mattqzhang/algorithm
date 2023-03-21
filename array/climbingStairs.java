/*
You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

lc 70
https://leetcode.com/problems/climbing-stairs/description/
*/

    // recursive, this will overflow when n is as big as 45.
    public int climbStairs(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;

        return climbStairs(n-1) + climbStairs(n-2);
    }


    // non-recursive solution
    public int climbStairs_v2(int n) {
        // base case
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;

        int i=3, p = 1, q = 2;
        // move the size-2 window of p and q
        while (i <= n) {
            q = p + q;
            p = q - p;
            i++;
        }
        return q;
    }
