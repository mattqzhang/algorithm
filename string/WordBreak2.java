/*
Word Break II
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.

lc 140
https://leetcode.com/problems/word-break-ii/description/
*/

public List<String> wordBreak(String s, List<String> wordDict) {
    return word_Break(s, wordDict, 0);
}

// <index, solution>
HashMap<Integer, List<String>> map = new HashMap<>();

public List<String> word_Break(String s, List<String> wordDict, int start) {
    // computed earlier
    if (map.containsKey(start)) {
        return map.get(start);
    }
    LinkedList<String> res = new LinkedList<>();
    // terminal case
    if (start == s.length()) {
        res.add("");
    }else {
        for (int end = start + 1; end <= s.length(); end++) {
           // find a valid word 
           if (wordDict.contains(s.substring(start, end))) {
                // recursively find the list solution of the remaining part, and attached to this word
                List<String> list = word_Break(s, wordDict, end);
                for (String l : list) {
                    res.add(s.substring(start, end) + (l.equals("") ? "" : " ") + l);
                }
            }
        }
    }
    map.put(start, res);
    return res;
}
