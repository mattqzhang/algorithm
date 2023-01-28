/*
Repeated Substring Detection
Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.

lc 459
*/

public static boolean repeatedSubstringPattern(String s) {
    int len = s.length();

    // need at least 2 copies, so only need to check till len/2
    for(int i=1; i<=len/2; i++){
        // len should be full multiples of i
        if(len % i ==0){
            // first copy from 0 to i
            String first = s.substring(0, i);
            boolean repeated = true;

            // check every copy of length i, if it's same as first copy
            for(int n=i; n<len; n+=i){
                String compare = s.substring(n, n+i);
                if(!compare.equals(first)) {
                    repeated = false;
                    break;
                }
            }
            if(repeated)
                return true;
        }
    }
    return false;
}

