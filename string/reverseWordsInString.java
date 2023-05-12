/*
Reverse Words in a String III
Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

lc 557
https://leetcode.com/problems/reverse-words-in-a-string-iii/description/
*/


 // using split function to get word array
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] str = s.split("\\s+");
        for (String sub : str) {
            char[] ca = sub.toCharArray();
            for (int i=ca.length-1; i>=0; i--) {
                sb.append(ca[i]);
            }
            sb.append(" ");
        }
        String res = sb.toString();
        return res.substring(0, res.length() -1);
    }


// manually trace the start/end index of each word

    public String reverseWords(String s) {
        String snew = "";

        int start = 0, end = 0;        

        for(int i = 0; i<s.length(); i++){
            end = i;
            //if((str.charAt(i) <'a' || str.charAt(i)>'z')
            if((s.charAt(i) ==' ')|| i==s.length()-1 ){
                //last char of the str should be included
                 if(i == s.length()-1)
                    end ++;
                
                char[] newword = s.substring(start, end).toCharArray();
                // reverse the newword
                char tmp;
                for (int j=0; j<newword.length/2; j++) {
                    tmp = newword[j];
                    newword[j] = newword[newword.length - 1 - j];
                    newword[newword.length - 1 - j] = tmp;
                }

                snew += new String(newword) + " ";
                //start of a new word
                start = i+1;
                if(start > s.length()) break;
            }
        }

        return snew.trim();
    }
