/*
Guess Number Higher or Lower

lc 374
https://leetcode.com/problems/guess-number-higher-or-lower/
*/

/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int lo = 1, hi = n;        
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int tmp = guess(mid);
            if (tmp == 0)
                return mid;
            if (tmp == 1)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return -1;
    }    
}
