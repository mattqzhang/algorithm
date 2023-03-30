/*
String to Integer (atoi)

int string followed by words

lc 8
https://leetcode.com/problems/string-to-integer-atoi/description/
*/

    public int myAtoi(String s) {
        int res = 0;
        s = s.trim();
        if(s.length() == 0) return 0;

        boolean neg = false;
        if (s.charAt(0) == '-') {
            neg = true;
            s = s.substring(1);
        } else if (s.charAt(0) == '+') {            
            s = s.substring(1);
        }

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (! (c >= '0' && c <= '9'))
                break;

            // overflow
            if (res >Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE/10 && c > '7' ))
                return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            
            res = res * 10 + c - '0';
        }

        return neg ? res * -1 : res;
    }

