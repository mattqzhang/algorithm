/*
Convert a Number to Hexadecimal
Given an integer num, return a string representing its hexadecimal representation. For negative integers, two’s complement method is used.

lc 405
https://leetcode.com/problems/convert-a-number-to-hexadecimal/description/
*/

    public String toHex(int num) {            
        if (num == 0) return "0";

        String res = "";
        char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        // get last 4 bits each time to convert it
        while (num != 0) {
            char c = map[num & 0xF]; // or num & 15, or num & 0b1111
            res = c + res;
            num >>>= 4;  // use unsigned shift
        }
        return res;        
    }
