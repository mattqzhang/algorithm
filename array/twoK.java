/*
Find the K-th element in two sorted arrays
Solution 1: use two pointers to iterate through the two arrays in k steps
Solution 2: binary search for the k-th element
*/


/* Find the K-th element in two sorted arrays */

public class twoK {

    /**********************************
     *  using two pointers to iterate through the two arrays
     *  */
    static int getK_merge(int a[], int b[], int k){
       
        int i=0, j=0;
        int cur = 0;
        while(i+j <k && i<a.length && j<b.length){
            if(a[i] < b[j]){
                i++;
            }
            else{
                j++;
            }
        }
       
        // one array runs out before we reach k
        while(i == a.length && i+j<k){ //a is the end, move to next one in b
            cur = b[j++];
        }
        while(j == b.length && i+j < k){ // b is the end, move to next one in a
            cur = a[i++];
        }
       
        // i+j = k now        
        return cur;       
    }

    /***********************************
     * binary search for the position of k
     */
   
    public static void main(String[] args) {
        int a[] = {1, 2, 5, 6};
        int b[] = {3, 4};
        int k = 5;
       
        int valK = getK_merge(a, b, k);
        System.out.println("by pointer merging: " + valK);

    }

}
