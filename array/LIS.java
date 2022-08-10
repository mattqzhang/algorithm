/*
Longest Increasing Sequence (LIS): find a subsequence of a given sequence in which the subsequence elements are in sorted order, lowest to highest, and in which the subsequence is as long as possible.
We can solve this problem using dynamic programming
*/

/* Longest Increasing Sequence */

import java.util.ArrayList;

public class LIS {

    // Dynamic Programming solution, O(n^2)
    public static void LIS_DP(int arr[]) {
        int size = arr.length;
        // max sequence length at the i-th element
        int len[] = new int[size];
        // idx of previous one for the max sequence at i.
        int idx[] = new int[size];       
       
        //1st is trivial
        len[0] = 1;
        idx[0] = -1;  //no previous one
        // max length till now, and the last index for this max length 
        int maxlen = 1;
        int maxidx = 0;        
       
        //go through all the elements
        for(int i=1; i<size; i++){
            // initialize
            len[i] = 1;
            idx[i] = -1;
            // explore all previous elements
            for(int j=0; j<i; j++){
                // a smaller one can be prefix
                if(arr[j] < a[i]){
                    if(len[j] + 1 > len[i]){
                        // improve the current solution
                        len[i] = len[j] + 1;
                        idx[i] = j;
                        //update global solution
                        if(len[i] > maxlen){
                            maxlen = len[i];
                            maxidx = i;
                        }                       
                    }
                }
            }
        }
       
        // retrieve the solution using maxidx the idx[]
        ArrayList<Integer> output = new ArrayList<Integer>();
        int i = maxidx;       
        while(i !=-1){
            output.add(0, arr[i]);           
            i = idx[i];
        }
        System.out.println(output);
     }

    //static final int a[] = { 0, 3, 1, 7, 2, 4, 9, 10, 5, 6, 8 };
    static final int a[] = {3, 0, 1, 7, 2, 4, 9, 10, 5, 15, 8};
    public static void main(String[] args) {
        System.out.println("solve by DP: ");
        LIS_DP(a);
       
        System.out.println("done");
    }

}
