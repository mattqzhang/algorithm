/*
 * Binary Search in a sorted arrary
 *
 * Author: Qing "Matt" Zhang
 * https://sites.google.com/site/mattzhangcube/home/coding
 */

public class bSearch {

    private static int bsearch(int a[], int start, int end, int x){
        if(start>end)
            return -1;
        //since a[] is sorted, you can also return a[0]-1 or a[len-1] +1
       
        int mid;
        int len = end - start +1;
        mid = start + (int)len/2;       
       
        if(a[mid] == x)
            return mid;
        else if(a[mid] > x)
            return bsearch(a, start, mid-1, x);
        else
            return bsearch(a, mid+1, end, x);
    }
   
    public static void main(String[] args) {
        int a[] = {0, 1,2,3,4};
        for(int x = -3; x < a.length+2; x++){
            int idx = bsearch(a, 0, a.length-1, x);
            System.out.println("idx =" + idx);
        }
    }
}
