/*
Base 7
Given an integer num, return a string of its base 7 representation.

lc 504
https://leetcode.com/problems/base-7/description/
*/

    public String convertToBase7(int num) {
        if (num == 0) return "0";
        
        String res = "";
        boolean neg = false;
        if (num < 0) {
            neg = true;
            num *= -1;
        }

        while (num > 0) {
            res = (num % 7) + res;
            num /= 7;
        }
        if (neg)
            res = "-" + res;
        
        return res;        
    }
