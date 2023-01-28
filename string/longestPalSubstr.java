/*
Longest Palindromic Substring
- DP solution: O(N^2) time, O(N^2) space
- expand from 2N-1 centers: O(N^2) time, O(1) space
*/


/* Find the Longest Palindromic Substring */

public class longestPalSubstr {

    /* Dynamic programming solution
     * O(N^2) time, O(N^2) storage
     * */
    static String longestPal_DP(String s) {
        int n = s.length();
        int start = 0;
        int maxLen = 1;

        boolean table[][] = new boolean[n][n]; // default is false

        // length = 1 base case
        // each char itself is a palindrome
        for (int i = 0; i < n; i++) {
            table[i][i] = true;
            start = i;
            maxLent = 1;
        }

        // length = 2 base case
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                table[i][i + 1] = true;
                start = i;
                maxLen = 2;
            }
        }

        // all length = 3 and up cases,
        // use DP to solve it
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                // if s[i+1 ... j-1] is palindrome
                //   then appending s[i] = s[j] is also one.
                if ((s.charAt(i) == s.charAt(j))
                        && (table[i + 1][j - 1] == true)) {
                    table[i][j] = true;
                    start = i;
                    maxLen = len;
                }
            }
        }
        return s.substring(start, start + maxLen); // substring end index is exclusive
    }

    /* Expanding from center
     * We have 2N-1 possible centers, each takes N to expand
     * O(N^2) time, O(1) storage
     * */
    static String expand(String s, int start, int end){
        while( start >= 0 && end <= s.length()-1 &&
                s.charAt(start) == s.charAt(end))
        {
            start --;
            end ++;
        }
        return s.substring(start+1, end);
    }
    
    static String longestPal_expand(String s){
        int n = s.length();
        if(n==0)
            return "";
        
        String result = "";        
        int maxlen = 0;
        int start = 0;
        int end = 0;
        while(start <n && end <n){
            String pal = expand(s, start, end);
            if(pal.length() > maxlen){
                maxlen = pal.length();
                result = pal;
            }
            if(start == end)
                end++;
            else
                start++;
        }
        return result;
    }
    
    public static void main(String[] args) {

        //String s = "abcbadefgacca"; // abcba at front
        // String s = "abcdaeceadacba"; //daecead in middle
         String s = "defgabccba"; // abccba at end
        String pal = longestPal_DP(s);
        System.out.println("DP solution:\t" + pal);
        
        pal = longestPal_expand(s);
        System.out.println("expand solution:\t" + pal);
    }

}

