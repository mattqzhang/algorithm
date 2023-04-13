/*
Removing Stars From a String

lc 2390
https://leetcode.com/problems/removing-stars-from-a-string/
*/


// this solution times out givne large input

    public String removeStars(String s) {
        String res = "";
        if (s.isEmpty()) return s;
        
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '*') {
                if (!res.isEmpty()) res = res.substring(0, res.length() -1);
            } else
                res += s.charAt(i);
        }
        return res;
    }


    // solve the problem backwards
    // if we see a star, we will skip one previous char
    public String removeStars(String s) {
        String res = "";
        if (s.isEmpty()) return s;

        int ct = 0;
        for (int i=s.length()-1; i>0; i--) {
            if (s.charAt(i) == '*') {
                ct ++;
            } else {  // not '*'
                if (ct == 0)
                    res = s.charAt(i) + res;
                else  // skip, as we have * later
                    ct --;
            }
        }
        return res;
    }
