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

/*
 * Reverse the whole string, or only reverse the order of the words
 *
 * Author: Qing "Matt" Zhang
 * https://sites.google.com/site/mattzhangcube/home/coding
 */
public class stringReverse {

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
   
    // reverse only the words
    static String revStr_word(String str){
        String snew = "";
        if(str.isEmpty())
            return snew;
       
        int start, end;
        start = end =0;
        String newword = "";
       
        for(int i = 0; i<str.length(); i++){
            end = i;
            //if((str.charAt(i) <'a' || str.charAt(i)>'z')
            if((str.charAt(i) ==' ')|| i==str.length()-1 ){
                //last char of the str should be included
                 if(i == str.length()-1)
                    end ++;
               
                newword = str.substring(start, end);
                snew = newword + snew;
                //start of a new word
                start = i ++;               
                if(start > str.length()) break;
            }               
        }
       
        return snew;
    }
   


    public static void main(String[] args){
        String str = " this     is a string 123 ";       
       
        String snew = revStr_sb(str);
        System.out.println("reverse using StringBuffer: " + snew);
       
        snew = revStr_arr(str);
        System.out.println("reverse as array: " + snew);
       
        snew = revStr_rec(str);
        System.out.println("reverse recursively: " +snew);
       
        snew = revStr_word(str);
        System.out.println("reverse words: " + snew);
    }
}




