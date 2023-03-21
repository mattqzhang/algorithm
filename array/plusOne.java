/*
You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.

lc 66
https://leetcode.com/problems/plus-one/
*/

    public int[] plusOne(int[] digits) {
        int n = digits.length;
        // use carry as +1
        int carry = 1;
        for (int i = n-1; i>=0; i--) {
            digits[i] += carry;
            if (digits[i] == 10) {
                digits[i] = 0;
                carry = 1;
            } else
                return digits;
        }
        // all 99...9s, carry to biggest one.
        int[] result = new int[n+1];
        result[0] = 1;
        return result;
    }

    // a more straightforward solution:
    public int[] plusOne_v2(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            // if it's not 9, no carry, add 1 and return
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            // otherwise set to 0, and carry to next digit.
            digits[i] = 0;
        }

        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;        
    }
