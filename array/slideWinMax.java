/*
Max value in a sliding window
Find the max value in an array within every sliding window of size w.
Solution:
Use a list to save the max values.
 - maintain the largest one at the front of the list.
- if the next value is not smaller than the tail, we can remove the tail(as it has latest time stamp)
- so values in the list is always decreasing in value, and increasing in time st.
- we then check if the head element is expired.
- head of the leftover list is the max for this window
*/

/* Find the max value in an array within every sliding window of size w.
 *
 * Solution:
 * Use a list to save the max values.
 * - maintain the largest one at the front of the list.
 * - if the next value is not smaller than the tail,
 *         we can remove the tail(as it has latest time stamp)
 * - so values in the list is always decreasing in value, and increasing in time st.
 * - we then check if the head element is expired.
 * - head of the leftover list is the max for this window
 * */

import java.util.*;

class doubleLL{
    int val;
    doubleLL next;
    doubleLL pre;
}

public class slideWinMax{

    static int[] slideMax (int a[], int w){
        int b[] = new int[a.length];
        // list saves the index of the max values
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(0);
        b[0] = a[0];
       
        // initialize the 1st w elements
        for(int i=1; i<w; i++){
            while(!list.isEmpty() && a[list.peekLast()]< a[i])
                list.removeLast();
            list.addLast(i);
            b[i] = a[list.peek()];
        }
       
        for(int i=w; i<a.length; i++){
            // remove all tail elements that are smaller than a[i]
            while(!list.isEmpty() && a[list.peekLast()]< a[i])
                list.removeLast();
           
            // check if head is expired
            // since we check it every round, so only the 1st element may expire
            if(!list.isEmpty() && list.peek() <=i-w )
                list.removeFirst();
               
            list.addLast(i);
            b[i] = a[list.peek()];
        }
       
        return b;
    }
   
    public static void main(String[] args) {
        int a[] = {3, 2, 5, 6, 9, 4, 7, 1, 4, 6, 8, 7, 10};
        int w = 3;
        int b[] =  slideMax(a, w);
        System.out.println(Arrays.toString(b));
    }

}

