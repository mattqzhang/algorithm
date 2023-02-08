/*
Bulls and Cows

Input: secret = "1807", guess = "7810"
Output: "1A3B"

Input: secret = "1123", guess = "0111"
Output: "1A1B"

lc 299
https://leetcode.com/problems/bulls-and-cows/
*/

/**
 * You write down a number and ask your friend to guess what the number is.
 * Each time your friend makes a guess, you provide a hint that indicates
 * how many digits in said guess match your secret number exactly in both
 * digit and position (called "bulls") and how many digits match the secret
 * number but locate in the wrong position (called "cows").
 * Your friend will use successive guesses and hints to eventually derive the secret number.
 *
 * Write a function to return a hint according to the secret number and friend's guess,
 * use A to indicate the bulls and B to indicate the cows.
 *
 * Please note that both secret number and friend's guess may contain duplicate digits.
* */

    public String getHint(String secret, String guess) {
        //bucket sort
        int[] ct = new int[10];

        int bull = 0, cow = 0;
        for(int i=0; i<secret.length(); i++){
            if(secret.charAt(i) == guess.charAt(i)) {
                bull++;
                continue;
            }else{
                // chars in secret, increase the bucket
                // if after increase, still <=0, it means guess set it earlier
                // so it's a cow.
                if (++ct[secret.charAt(i) - '0'] <= 0)
                    cow ++;

                // decrease the guess char ct
                // if after decrease still >=0, means a match with secret
                if (--ct[guess.charAt(i) - '0'] >= 0)
                    cow ++;
            }
        }
        String res = bull + "A" + cow + "B";
        return res;
    }
