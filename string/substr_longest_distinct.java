/*
Longest Substring with at most K distinct characters
Given a string, find the length of the longest substring T that contains at most k distinct characters.
*/

public int lengthOfLongestSubstringKDistinct(String s, int k) {
    int n = s.length();
    if (n== 0 || k == 0)
        return 0;

    // define sliding window
    int front = 0;
    int end = 0;
    // hashmap character -> ct in the sliding window
    HashMap<Character, Integer> hm = new HashMap<Character, Integer>();

    int maxLen = 0;
    int distinct = 0;

    while (front < n) {
        // add new character and move right pointer
        if(!hm.containsKey(s.charAt(front))) {
            hm.put(s.charAt(front), 1);
            distinct ++;
        } else {
            hm.put(s.charAt(front), hm.get(s.charAt(front)) + 1);
        }

        // move left pointer to satisfy K
        while(distinct > k) {
            int ct = hm.get(s.charAt(end));
            if(ct - 1 == 0) {  
                hm.remove(s.charAt(end));
                distinct --;
            }else
                hm.put(s.charAt(end), ct - 1);
            end ++;
        }
        // update length
        if(distinct <= k) {
            if (front - end + 1 > maxLen)
                maxLen = front - end + 1;
        }
        // move right pointer
        front ++;
    }
    return maxLen;
}

   // HashMap character -> its rightmost position in the sliding window
public int lengthOfLongestSubstringKDistinct(String s, int k) {
    int n = s.length();
    if (n*k == 0) return 0;

    // sliding window left and right pointers
    int left = 0;
    int right = 0;
    HashMap<Character, Integer> hashmap = new HashMap<Character, Integer>();

    int max_len = 1;

    while (right < n) {
        // add new character and move right pointer
        hashmap.put(s.charAt(right), right++);

        // slidewindow contains k+1 characters
        if (hashmap.size() == k + 1) {
            // delete the leftmost character
            int del_idx = Collections.min(hashmap.values());
            hashmap.remove(s.charAt(del_idx));
            // move left pointer of the slidewindow
            left = del_idx + 1;
        }

        max_len = Math.max(max_len, right - left);
    }
    return max_len;
}

