/*
Find all numbers in a range containing a given digit.
Given a digit d and an integer x (can be negative), find all the numbers that contain the digit d within the inclusive range 0 to x. Return numbers in ascending order.
*/

import java.util.*;

/*
 * Given a digit d and an integer x (can be negative), find all the numbers that
 * contain the digit d within the inclusive range 0 to x.
 * Return numbers in ascending order.
 * */

public class allDigit {
    static ArrayList<Integer> find_digit(int digit, int range) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        boolean neg = (range>=0)? false: true;
        if(neg)
            range = range * (-1);

        // no solution
        if (digit > range)
            return result;

        // length of the length(number of digits) of range, at least one
        int len = 1;
        int tmp = range / 10;
        while (tmp > 0) {
            tmp = tmp / 10;
            len++;
        }

        int val = digit;
        // single digit is itself
        result.add(val);

        /* we do it for 1-digit, 2-digit, ..., k-digit in turns
         * For length 2, we append 1-d and d-9 to the front of digit d,
         *         and 0-9 to the end of d
         *
         * For length i+1 > 2 , we append 1-9 to the (i+1)th order position
         * of all length <=i values.
         *     - no need to append to the end, as it's included
         *         in the adding to the front case.
         *         (for example: if d=7, we append 475 to 4750,
         *         it's the same as append 750 with a 4 at the front)
         */

        int cnt = 1;
        while (cnt <= len - 1) {

            // newResult is used to save length i+1 values by appending all existing values
            ArrayList<Integer> newResult = new ArrayList<Integer>();

            // For all values in the previous result list, append 1...9 to the
            // front, as long as it's less than range

            // add to the front 0... d
            for (int i = 1; i < 10; i++) {

                int top = i * (int) Math.pow(10, cnt);
                // get each value in current result set
                for (int j = 0; j < result.size(); j++) {
                    val = result.get(j);
                    val += top;
                    if (val < range)
                        newResult.add(val);
                    else
                        break;
                }
            }

            // To construct length 2 values, we need to append 0...9 to the end
            // For longer length i values, don't need to do so,
            //         as it is included in the adding to front case

            // add last digit 0 ...9 to get complete length 2 sequence
            if(cnt == 1 && digit !=0){
                for (int i = 0; i < 10; i++) {
                    if (i == digit) continue;  // things like 77 already counted above
                    // get each value in current result set
                    for (int j = 0; j < result.size(); j++) {
                        val = result.get(j);
                        val = val * 10 + i;
                        if (val <= range)
                            newResult.add(val);
                        else
                            break;
                    }
                }
            }

            result.addAll(newResult);
            cnt++;
        }

        // for negative values, we need to reverse the result and then multiple by -1
        // to make the list increasing
        if(neg){
            ArrayList<Integer> newResult = new ArrayList<Integer>();
            for(int i=0; i<result.size(); i++){
                val = result.get(result.size()-i-1);
                val = val * (-1);
                newResult.add(val);
            }
            result = newResult;
        }
        return result;
    }

    public static void main(String args[]) {
        ;
        int digit = 7;
        int range = 210;
        //int range = -120;
        ArrayList<Integer> result = find_digit(digit, range);
        System.out.println(result);
    }
}

