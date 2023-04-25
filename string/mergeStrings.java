/*
Merge Strings Alternately

lc 1768
https://leetcode.com/problems/merge-strings-alternately/description/
*/

    public String mergeAlternately(String word1, String word2) {
        if (word1.length() == 0) return word2;
        if (word2.length() == 0) return word1;

        int i = 0;
        String res = "";
        while(i < word1.length() && i < word2.length()) {
            res += word1.charAt(i);
            res += word2.charAt(i);
            i++;
        }

        while(i < word1.length()) {
            res += word1.charAt(i);
            i++;
        }
        while(i < word2.length()) {
            res += word2.charAt(i);
            i++;
        }
        return res;        
    }



    // simpler code:

    public String mergeAlternately(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < Math.max(m, n); i++) {
            if (i < m) {
                result.append(word1.charAt(i));
            }
            if (i < n) {
                result.append(word2.charAt(i));
            }
        }

        return result.toString();
    }
