/*
Anagram: Two strings are anagrams if they are composed of the same letters, and each letter appear the same number of times, ignoring white spaces. To test if two strings are anagram, we can
- solve by sorting: sort both strings, then compare if the resulted new strings are the same.
- solve by hashing: put each character of the 1st string as the key into a map, and value is its count. 
  Then reduce each character count from the 2nd string. If some character is not found, or if after removing all s2 there're still things left in the map, they're not anagram.

In this file I also include auxiliary functions to
- sort a string using bucket sort
- remove spaces from string

lc 242
https://leetcode.com/problems/valid-anagram/description/
*/

import java.util.*;

public class anagram {

    /* we can sort the string using the java array function directly */
    static String sortString_dflt(String in) {
        char[] tmp = in.toCharArray();
        Arrays.sort(tmp);
        return new String(tmp);
    }

    /* Sort a string using bucket sort
     * only consider characters between 'a' to 'z'
     * ignore other characters including spaces.
    */
    static String sortString(String s){
        String snew = "";
        int[] ct = new int[26];
       
        //find the bucket for each s[i], and add the count       
        for(int i=0; i<s.length(); i++)
            if(s.charAt(i) >='a' && s.charAt(i)<= 'z')
                ct[s.charAt(i) - 'a'] ++;               
       
        //go through buckets and concatenate the results
        for(int i=0; i<ct.length; i++)
            for(int j=0; j<ct[i]; j++){
                char cur = (char)('a'+ i);
                snew += cur;
            }
       
        return snew;
    }
       
    /* remove space in a string */
    static String removeSpace(String s){
        String snew = "";
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) != ' ')
                snew += s.charAt(i);
        }
        return snew;
    }
   
    static boolean isAna_hash(String s1, String s2) {
        boolean is_anagram = true;
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();

        /* construct hash map for s1 */
        for (int i = 0; i < s1.length(); i++) {           
            Integer I = (Integer) hm.remove(s1.charAt(i));
            if (I != null) {
                hm.put(s1.charAt(i), new Integer(I.intValue() + 1));
            } else {
                hm.put(s1.charAt(i), new Integer(1));
            }
        }
       
        /* remove each character of s2 from the hashmap */
        for (int i = 0; i < s2.length(); i++) {
            // I is the stored count value before removing
            Integer I = (Integer) hm.remove(s2.charAt(i));
            if (I != null) {
                if (I.intValue() > 1)
                    hm.put(s2.charAt(i), new Integer(I.intValue() - 1));
                    //else if previous count is already 1, just remove it from map.
            } else {
                is_anagram = false;
                break;
            }
        }
        /* after removing all s2, map should be empty now */
        if (!hm.isEmpty())
            is_anagram = false;

        return is_anagram;
    }
   
    public static void main(String[] args) {

        //String s1 = "ac dbsd  ea ";
        //String s2 = "dc da eb as";
        String s1 = "eleven plus two ";
        String s2 = "twelve plus one";   
       
        /* test by sorting */
        String sortS1 = sortString(s1);
        String sortS2 = sortString(s2);
        if (sortS1.equals(sortS2))
            System.out.println("anagram solved by sorting: true ");
        else
            System.out.println("anagram solved by sorting: false ");       
       
        /* test by hashing */
        String newS1 = removeSpace(s1);
        String newS2 = removeSpace(s2);
        if(isAna_hash(newS1, newS2))
            System.out.println("anagram solved by hasing: true ");
        else
            System.out.println("anagram solved by hashing: false ");       
       
        System.out.println();
    }
}

