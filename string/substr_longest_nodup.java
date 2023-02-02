/*
Longest Substring with no repeating characters.
We can scan the string only once. Every time getting a new char, update the current sequence.
*/


/* Given a string, find the length of the longest substring without repeating characters.
 * Solution:
 * Maintain a sequence of characters with no repeating characters.
 * Every time if we get a new char, extend the current sequence, and update max
 * If it's a repeating char, we go to the previous time it appears,
 * and let the current sequence start from the next position. 
 *
 * We scan the sequence only once, so O(N) time.
 * We need O(1) space to record index of each char's last appearance.
 *  basic idea: scan each char, 
 *    if it's not seen before, expand current sequence. 
 *    else, start a new sequence 
 */

public class substr_longest_nodup {

    static void substr_nodup(String str) {
        // assume only contain characters 'a' to 'z'.
        // can expand easily
        int idx[] = new int[26];
        int start = 0, i = 0;
        int maxlen = 0, maxstart = 0;
        // initialize all index to -1
        for (i = 0; i < idx.length; i++) {
            idx[i] = -1;
        }

        for (i = 0; i < str.length(); i++) {
            int charpos = str.charAt(i) - 'a';

            // new char for the current sequence
            if (idx[charpos] < start) {
                idx[charpos] = i;

                // update max
                if (i - start+1 > maxlen) {
                    maxlen = i - start +1;
                    maxstart = start;
                }
            } else { // repeated               
                // reset start from the place after the repeated one
                start = idx[charpos] + 1;
                idx[charpos] = i;
            }
        }
        System.out.println("max substring is from position " + maxstart + ": "
                + str.substring(maxstart, maxstart + maxlen));
    }

    public static void main(String[] args) {

        String str = "abcabdcbb";
        //String str = "bba";
        substr_nodup(str);
       
        System.out.println("done");
    }
}
