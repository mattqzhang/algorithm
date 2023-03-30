/*
Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.

lc 258
https://leetcode.com/problems/add-digits/description/
*/

    public int addDigits(int num) {
        while (num >= 10) {
            int res = 0;
            while (num > 0) {
                res += num % 10;
                num = num / 10;
            }
            num = res;
        }
        return num;        
    }
