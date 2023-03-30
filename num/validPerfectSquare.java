/*
Valid Perfect Square
Given a positive integer num, return true if num is a perfect square or false otherwise.

lc 367
https://leetcode.com/problems/valid-perfect-square/description/
*/

    public boolean isPerfectSquare(int num) {
        if (num == 1) return true;

        // all these need to be long time to avoid overflow, while computing mid
        long start = 1, end = num;
        while (start <= end) {
            long mid = (start + end)/2;
            if (mid * mid == num) return true;
            if (mid * mid < num)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return false;      
    }
