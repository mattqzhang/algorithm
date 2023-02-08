/*
Longest Word Chain
Given a list of words, each word consists of English lowercase letters.
Let's say word1 is a predecessor of word2 if and only if we can add exactly one letter anywhere in word1 to make it equal to word2.  
Return the longest possible length of a word chain with words chosen from the given list of words.

Input: words = ["a","b","ba","bca","bda","bdca"]
Output: 4
Explanation: One of the longest word chains is ["a","ba","bda","bdca"].

lc 1048
https://leetcode.com/problems/longest-string-chain/
*/

// if first string is part of word, differ by only 1 char
boolean isSub(String part, String word){
    if(part.length() != word.length() -1)
        return false;

    int i=0, j=0;
    while(i<part.length() && j<word.length() && part.charAt(i) == word.charAt(j)){
        i++;
        j++;
    }
    // word has one more char
    if(i == part.length())
        return true;

    // skip the unmatached char
    j++;

    while(i<part.length() && j<word.length() && part.charAt(i) == word.charAt(j)){
        i++;
        j++;
    }
    return (i == part.length() && j == word.length());
}

public int longestStrChain(String[] words) {
    if(words == null || words.length == 0)
        return 0;

    // sort words based on length
    Arrays.sort(words, (a,b)->{
        return a.length() - b.length();
    });
    // Map: len -> start idx in words[];
    // so the word idx of len-1 is between hm.get(len-1) and hm.get(len) 
    HashMap<Integer, Integer> hm = new HashMap<>();

    int dp[] = new int[words.length];
    Arrays.fill(dp, 1);

    int max = 1;
    int prevLen = 0;

    // for each lenght i, we enumerate chain length from length i-1
    for(int i=0; i< words.length; i++){
        String word = words[i];
        int len = word.length();
        // starting words of new length
        if(len != prevLen) {
            hm.put(len, i);
            prevLen = len;
        }

        // no words of len -1, so not tracable.
        if(!hm.containsKey(len - 1))
            continue;

        // j traces index of all words of len-1
        for(int j=hm.get(len-1); j<hm.get(len); j++){
            String part = words[j];
            if(isSub(part, word)){
                dp[i] = Math.max(dp[j]+1, dp[i]);
                max = Math.max(max, dp[i]);
            }
        }
    }
    return max;
}
