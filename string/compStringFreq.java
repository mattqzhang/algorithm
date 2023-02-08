/*
Compare Strings by Frequency of the Smallest Character
Let's define a function f(s) over a non-empty string s, which calculates the frequency of the smallest character in s. For example, if s = "dcce" then f(s) = 2 because the smallest character is "c" and its frequency is 2.
Now, given string arrays queries and words, return an integer array answer, where each answer[i] is the number of words such that f(queries[i]) < f(W), where W is a word in words.

lc 1170
https://leetcode.com/problems/compare-strings-by-frequency-of-the-smallest-character/
*/


// get frequency of smallest char. 
// Note that we don't need bucket sort to do the job.
public int getFreq(String s){
    int ct = 0;
    char small = 'z';
    for(int i=0; i<s.length(); i++){
       if(s.charAt(i) == small)
           ct++;
       else if(s.charAt(i) < small) {
           small = s.charAt(i);
           ct = 1;
       }
    }
    return ct;
}

public int[] numSmallerByFrequency(String[] queries, String[] words) {
    int[] res = new int[queries.length];

    // get frequency of each word[i]
    int[] wordFreq = new int[words.length];
    for(int i=0; i<words.length; i++){
        wordFreq[i] = getFreq(words[i]);
    }

    for(int i=0; i<queries.length; i++){
        int f = getFreq(queries[i]);
        for(int j=0; j<words.length; j++){
            if(f < wordFreq[j])
                res[i]++;
        }
    }
    return res;
}
