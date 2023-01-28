/*
Longest Common Substring(LCS)
We can us dynamic programming to solve this problem.
*/

public class LCS {
    /* Longest common substring
     * Dynamic Programming solution
     * */
    static String LCS_dp(String s1, String s2){
        String s = "";
       
        int len[][] = new int[s1.length()][s2.length()];
        len[0][0] = 0;

        int maxlen = 0;
        int start = 0;   
       
        for(int i = 0; i< s1.length(); i++){
            for(int j=0; j<s2.length(); j++){
                if(s1.charAt(i) == s2.charAt(j)){
                    if(i==0 || j==0)
                        len[i][j] = 1;   
                    else
                        len[i][j] = len[i-1][j-1] + 1;
                   
                    if(len[i][j] > maxlen){
                        maxlen = len[i][j];
                        start = i + 1 - maxlen;
                    }
                }else{
                    len[i][j] = 0;           
                }
            }
        }
        s = s1.substring(start, start + maxlen );
        return s;
    }

    public static void main(String[] args) {
   
        String s1 = "abcdefgh";
        String s2 = "xyabdefbcdeafg";    //bcde
        String s = LCS_dp(s1, s2);
        System.out.println(s);
    }

}
