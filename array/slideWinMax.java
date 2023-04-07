/*
Max value in a sliding window
Find the max value in an array within every sliding window of size w.

lc 239
https://leetcode.com/problems/sliding-window-maximum/description/
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


    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length - k + 1;
        int maxWin[] = new int[n];
        // list saves the index of the max values
        LinkedList<Integer> list = new LinkedList<>();

        // initialize the 1st k elements
        for (int i=0; i<k; i++) {
            while(!list.isEmpty() && nums[list.peekLast()] < nums[i])
                list.removeLast();
            list.add(i);
        }
        maxWin[0] = nums[list.peek()];

        // move window
        for (int i=k; i< nums.length; i++) {
            while(!list.isEmpty() && nums[list.peekLast()] < nums[i])
                list.removeLast();
            list.add(i);

            // check if head is expired
            // since we check it every round, so only the 1st element may expire
            if (!list.isEmpty() && list.peek() <= i-k)
                list.removeFirst();
            maxWin[i-k+1] = nums[list.peek()];
        }

        return maxWin;  
    }


// this solution starts counting from first element 

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

