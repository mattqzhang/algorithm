/*
Number to words
Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 2^31 - 1.

lc 237
https://leetcode.com/problems/integer-to-english-words/
*/

import java.util.*;

public class test1 {

    String[] nums = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String parseHundreds(int val){
        String res = "";
        if(val == 0)
            return res;

        int dbit = val % 10;
        val /= 10;

        int tbit = 0, hbit = 0;
        if(val>0) {
            tbit = val % 10;
            val /= 10;
            if(val > 0){
                hbit = val % 10;
            }
        }
        if(tbit == 0) {
            res = (dbit == 0) ? "" : nums[dbit - 1];
        } else if(tbit == 1){
            res = teens[dbit];
        } else {
            res = (dbit ==0) ? tens[tbit - 2] : tens[tbit - 2] + " " + nums[dbit - 1];
        }
        if(hbit > 0)
            res = nums[hbit -1] + " Hundred " + res;

        return res.trim();
    }

    public String numberToWords(int val){
        String s = "";

        if(val == 0)
            return "Zero";

        if(val >= 1000000000) {
            int top = val/1000000000;
            val %= 1000000000;
            s = s + parseHundreds(top) + " Billion";
        }

        if(val >= 1000000) {
            int top = val/1000000;
            val %= 1000000;
            s = s + " " + parseHundreds(top) + " Million";
        }

        if(val >= 1000) {
            int top = val/1000;
            val %= 1000;
            s = s + " " + parseHundreds(top) + " Thousand";
        }

        if(val != 0)
            s = s + " " + parseHundreds(val);

        return s.trim();
    }


    public static void main(String[] args){
        int val = 1000111023;
        String s = new test1().numberToWords(val);

        System.out.println(s);
    }
}
