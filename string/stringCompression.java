/*
String Compression

lc 443
https://leetcode.com/problems/string-compression/description/
*/

    public int compress(char[] chars) {
        if (chars.length == 1)
            return 1;
        
        int ct = 1;
        String res = "";
        res += chars[0];
        
        for (int i=1; i < chars.length; i++) {
            if (chars[i] == chars[i-1]) {
                ct ++;
            } else { // start a new char sequence
                if (ct > 1) {
                    res += ct;
                }
                ct = 1;
                res += chars[i];
            }
        }
        // last char may be a repeated char
        if (ct > 1) 
            res += ct;

        // copy string to original char array
        for (int i=0; i< res.length(); i++) {
            chars[i] = res.charAt(i);
        }

        return res.length();        
    }
