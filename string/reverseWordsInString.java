/*
Reverse Words in a String III

lc 557
https://leetcode.com/problems/reverse-words-in-a-string-iii/description/
*/

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
