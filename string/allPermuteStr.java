/*
All permutations of a String
Note that Java String is immutable, so I included a dedicated function to swap characters in the String.
*/

import java.util.*;

public class allPermuteStr {
   
    // swap characters in a String.
    // Note String is immutable, cannot swap directly
    static String swap(String str, int i, int j) {
        char[] c = str.toCharArray();
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
        String swappedString = new String(c);
        return swappedString;
    }
   
    //all permutations in a String
    static void allPermStr(String inStr, ArrayList<String> permStr, int i){
        // end case
        if(i == inStr.length()-1){
            permStr.add(inStr);
        }else{
            // for each j later than i, swap and recursive call
            for(int j=i; j<inStr.length(); j++){
                inStr = swap(inStr, i, j);
                allPermStr(inStr, permStr, i+1);
                inStr = swap(inStr, i, j);
            }
        }       
    }
   
    public static void main(String[] args) {
        String inStr = "abc";
        ArrayList<String> permStr = new ArrayList<String>();
        allPermStr(inStr, permStr, 0);
        System.out.println(permStr);           
    }
}
