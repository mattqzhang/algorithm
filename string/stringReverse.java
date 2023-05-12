/*
Revese a String: There are so many ways to reverse a string:
- using Java StringBuffer
- treat it as an array
- recursive solution
Reverse the word sequence in a String.

lc 344
https://leetcode.com/problems/reverse-string/
*/

public void reverseString(char[] s) {
    if(s.length == 0)
        return;
    int left = 0, right = s.length - 1;
    while(left < right){
        char c = s[left];
        s[left] = s[right];
        s[right] = c;
        left ++;
        right --;
    }
    return;
}


    // reverse using java StringBuffer
    static String revStr_sb(String str) {
        StringBuffer sb = new StringBuffer(str);
        return sb.reverse().toString();
      }
   
    //reverse a string using Java string built-in methods
    //by treating it as an array, output directly from the end
    static String revStr_arr(String str){
        String snew = "";
        for(int i=str.length()-1; i>=0; i--){
            snew += str.charAt(i);
        }
        return snew;
    }
   
    // recursive solution
    static String revStr_rec(String str){
        String snew = "";
        if(str.isEmpty())
            return snew;       
        // 1st char
        snew = str.substring(0,1);
        // recursively reverse the remaining, and attach 1st to end
        snew = revStr_rec(str.substring(1)) + snew;
       
        return snew;
    }
   
