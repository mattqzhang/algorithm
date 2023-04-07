/*
Max distance of two order elements
Given an integer array, find the maximum distance of A[i] and A[j] s.t. A[i] < A[j]
We can have a straightforward O(N^2) algorithm and a more concise O(N) algorithm.
*/

import java.util.Arrays;

/* Given an array of integers,
 * find the maximum of j-i subjected to the constraint of A[i] < A[j].
 */

public class maxDist {

    /*
     * solution 1: O(N^2)
     * For each a[i], check from a[n-1] backwards.
     * Find the first a[j] > a[i], break, that's the max(j-i) for a[i].
     * If it's bigger than the global max, update as the global.
     */
    static void maxDis_v1(int a[]) {
        int start = 0, end = 0;
        int max = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = a.length - 1; j > i && j - i > max; j--) {
                // we search backwards, so when we found one solution,
                // it must be max for this i (notice the j - i > max condition above),
                // and we can break and probe the next i.
                if (a[j] > a[i]) {
                    max = j - i;
                    start = i;
                    end = j;
                    break;
                }
            }
        }
        System.out.println("\tmax distance is: " + max + ", between " + start
                + " and " + end);
    }

    /* Solution 2: O(N)
     * Observe the properties:
     * (1) For starting point: if a[i] < a[i+1], then i+1 cannot be a starting point
     * (2) For ending point: if a[i] < a[i+1], then i cannot be a ending point
     */
    static void maxDis_v2(int a[]) {
        int len = a.length;
        int startval[] = new int[len];
        int endval[] = new int[len];
           
        // starting values
        startval[0] = a[0];
        for (int i = 0; i < len-1; i++)
            startval[i+1] = (startval[i] < a[i+1] ? startval[i] : a[i+1]);
                     
        // ending values
        endval[len-1] = a[len-1];
        for(int i = len-1; i>0; i--)
            endval[i-1] = (a[i-1] <= endval[i] ? endval[i] : a[i-1]);
       
        int max = 0, start = 0, end = 0;
        int i=0, j=0;
        while(i<len && j<len){
            if(startval[i] < endval[j]){
                if(j-i > max){
                    max = j-i;
                    start = i;
                    end = j;
                }
                // move endval forward, and see if we can get a better solution
                j++;
            }else
                // cannot be better than the current one
                // so don't need to update max
                i++;
        }
               
        System.out.println("\tmax distance is: " + max + ", between " + start
                + " and " + end);
    }
   
    public static void main(String[] args) {

        int a[] = { 4, 3, 5, 2, 1, 3, 2, 3 };
        maxDis_v1(a);
        maxDis_v2(a);
        System.out.println("done");

    }
}
