/*
Implement strStr()
Find the index of the substring in source string
*/


public static int strStr(String src, String sub) {
    if(src.length() == 0 && sub.length() != 0)
        return -1;
    if(sub.length() == 0)
        return 0;

    for(int i=0; i <= src.length() - sub.length(); i++){
        for(int j=0; j<= sub.length(); j++){
            // match to the end of sub, return start
            if(j == sub.length())
                return i;
            if(src.charAt(i+j) != sub.charAt(j))
                break;
        }
    }
    return -1;
}

