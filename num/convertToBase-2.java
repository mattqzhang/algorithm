/*
Convert to Base -2
Given an integer n, return a binary string representing its representation in base -2.

lc 1017
https://leetcode.com/problems/convert-to-base-2/description/
*/

    public String baseNeg2(int n) {
        if (n == 0) return "0";

        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            int rem = n % (-2);
            n /= -2;
            if (rem < 0) {
                rem += 2;
                n++;
            }
            sb.insert(0, rem);
        }
        return sb.toString();
    }
