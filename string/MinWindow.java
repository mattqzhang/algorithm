/*
Minimum Window Substring
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
*/

public String minWindow(String s, String t) {
    if(s.length() == 0 || t.length() == 0)
        return "";

    HashMap<Character, Integer> hm = new HashMap<>();
    for(int i=0; i<t.length(); i++){
        if(hm.containsKey(t.charAt(i)))
            hm.put(t.charAt(i), hm.get(t.charAt(i)) + 1);
        else
            hm.put(t.charAt(i), 1);
    }

    int target = hm.size();

    HashMap<Character, Integer> curWin = new HashMap<>();
    int same = 0;

    // ans list of the form (window length, left, right)
    int[] res = {-1, 0, 0};

    int l=0, r=0;
    //expand right
    while(r < s.length()){
        char c = s.charAt(r);
        int ct = curWin.getOrDefault(c, 0);
        curWin.put(c, ct + 1);

        if(hm.containsKey(c) && hm.get(c).intValue() == curWin.get(c).intValue())
            same ++;

        // shrink left
        while(l<=r && same == target) {
            // save current solution
            if (res[0] == -1 || r - l + 1 < res[0]) {
                res[0] = r - l + 1;
                res[1] = l;
                res[2] = r;
            }
            c = s.charAt(l);
            l++;
            curWin.put(c, curWin.get(c) - 1);
            if(hm.containsKey(c) && hm.get(c).intValue() > curWin.get(c).intValue())
                same --;
        }
        r++;
    }
    return res[0] == -1 ? "" : s.substring(res[1], res[2]+1);
}

