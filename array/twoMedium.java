/*
Solution 1: use two pointers to iterate through the two arrays in k steps
Solution 2: binary search for the k-th element
https://www.geeksforgeeks.org/median-two-sorted-arrays-different-sizes-ologminn-m/
*/

/* find the medium of two sorted arrays */

public class twoMedium {

    // find by counting and merging the arrays, O(N)
    // for total odd numbers, medium is the value at (n/2 +1)
    // for total even numbers, medium is the avg of (n/2) and (n/2+1)
    static float ctMedium(int a[], int b[]){
        assert(a.length>0 && b.length >0);
       
        int n = a.length + b.length;
        boolean odd = true;       
        if(n%2 ==0)   
            odd = false;       
   
        float medium = 0;
        int current = 0;
       
        int i=0, j=0;
        while(i<a.length && j<b.length && (i+j) < n/2){
            if(a[i] < b[j]){
                i++;               
            }
            else{               
                j++;
            }
        }
       
        while(i==a.length && (i+j) <n/2){
            current = b[j];
            j++;
        }
        while(j==a.length && (i+j) <n/2){
            current = a[i];
            i++;
        }
       
        // now we're at i+j = n/2 point
        // we need the next one at (n/2+1) for computation of medium
        int next;
        if(i==a.length)  // i is already out of range
            next = b[j];
        else if (j == b.length)    // j is already out of range
            next = a[i];
        else        // next smallest one
            next = a[i]<b[j]? a[i] : b[j];
       
        if(odd){    //next value at (n/2+1) is medium
            medium = next;
        }else{        // avg of current n/2 and next (n/2+1) is medium
            medium = (float)(current + next)/2;
        }
       
        return medium;
    }
   
    /****************************************************
     *  binary search for the medium, O(lgN)
     *  */
    static float bsMedium(int a[], int b[]){
        float medium = 0;
       
       
        return medium;       
    }
   
    public static void main(String[] args) {
        int a[] = {1, 2, 6, 8, 9, 10};
        int b[] = {3, 4, 5, 7};
   
        float medium = ctMedium(a, b);
        System.out.println(" by counting: " + medium);
    }

}

