/*
Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.

You must not use any built-in exponent function or operator.

lc 69
https://leetcode.com/problems/sqrtx/description/
*/

    public static int mySqrt(int x) {
        if (x==0 || x == 1)
            return x;

        int start = 1, end = x, res = 0;
        while (start <= end) {
            // don't do (start + end)/2, may overflow
            int mid = start + (end - start)/2;

            if (x/mid == mid)
                return mid;

            // don't do "mid*mid > x", may overflow
            if (x/mid < mid)
                end = mid -1;
            else { // mid * mid < x
                start = mid + 1;
                // this may be an answer, if we have start >= end at this step
                res = mid;
            }
        }

        return res;
    }
