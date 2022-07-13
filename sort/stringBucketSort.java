/*
 * Sort a string using bucket/counting sort
 * Author: Qing "Matt" Zhang
 * https://sites.google.com/site/mattzhangcube/home/coding
*/

public class stringBucketSort{
    /* Sort a string using bucket sort.
     * we only count characters between 'a' to 'z'
     * other characters including spaces are ignored.
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

   public static void main(String args[]){
     String s = "qewtqasdfrqertqwetqewrqw123412fmobitmnnqpqoweouqroietureiytjkhlfakjsdgfz,xmzxcbvbdjvbf";
     s = sortString(s);
     System.out.println(s);
  }
}

