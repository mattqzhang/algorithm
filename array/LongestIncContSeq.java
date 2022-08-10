/*
Longest Increasing Continuous Sequence: find a continuous and sorted subsequence of a given sequence.
We can simply go through the sequence in one pass, and update or reset the current length at each step.
*/

public class LongestIncContSeq {

    /* longest increasing continuous subsequence */
    static void LICS(int a[]){
        int maxlen = 1;
        int maxstart = 0;
       
        int len = 1;
        int start = 0;
       
        for(int i=1; i<a.length; i++){
            // increasing, update the length
            if(a[i] > a[i-1]){
                len ++;
                if(len > maxlen){
                    maxlen = len;
                    maxstart = start;
                }                   
            }
            // non-increasing, reset length count
            else{
                len = 1;
                start = i;
            }
        }
        System.out.println("the max length is " + maxlen +
                ", starting from idx " + start);
    }
   
    public static void main(String[] args) {
        int a[] = {5, 10, 0, 2, 8, 7, 3, 5, 15, 20};
        LICS(a);                   
    }
}


