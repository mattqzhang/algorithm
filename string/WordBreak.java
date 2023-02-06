/*
Word Break I
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

lc 139
https://leetcode.com/problems/word-break/
*/

public boolean wordBreak_bruteforce(String s, List<String> wordDict) {
    if (s.isEmpty())
        return true;
    for(int i=0; i<s.length(); i++){
        if(wordDict.contains(s.substring(0,i+1)) && wordBreak_bruteforce(s.substring(i+1), wordDict))
            return true;
    }
    return false;
}

// dynamic programming
public boolean wordBreak(String s, List<String> wordDict) {
    if (s.isEmpty())
        return true;

    // hasPath[i] is the existance of solution for first i chars in s
    boolean hasPath[] = new boolean[s.length() + 1];
    Arrays.fill(hasPath, false);
    // empty string is true;
    hasPath[0] = true;

    for(int i=1; i<=s.length(); i++){
        for(int j=0; j<i; j++){
            if(hasPath[j] == true && wordDict.contains(s.substring(j, i))) {
                hasPath[i] = true;
                break;
            }
        }
    }
    return hasPath[s.length()];
}

// breath first search, similar to the reachability problem
public boolean wordBreak(String s, List<String> wordDict) {
    Queue<Integer> queue = new LinkedList<>();
    int[] visited = new int[s.length()];
    queue.add(0);
    while (!queue.isEmpty()) {
        int start = queue.remove();
        // char position is not checked before
        if (visited[start] == 0) {
            for (int end = start + 1; end <= s.length(); end++) {
                // find a valid word, then try reachability from the end index 
                if (wordDict.contains(s.substring(start, end))) {
                    queue.add(end);
                    // find a solution
                    if (end == s.length()) {
                        return true;
                    }
                }
            }
            visited[start] = 1;
        }
    }
    return false;
}

// dp (actually it's the same as 2nd solution)
public boolean wordBreak(String s, List<String> wordDict) {
    boolean[] dp = new boolean[s.length() + 1];
    dp[0] = true;
    for (int i = 1; i <= s.length(); i++) {
        for (int j = 0; j < i; j++) {
            if (dp[j] && wordDict.contains(s.substring(j, i))) {
                dp[i] = true;
                break;
            }
        }
    }
    return dp[s.length()];
}

