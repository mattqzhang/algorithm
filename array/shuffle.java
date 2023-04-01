/*
lc 384
https://leetcode.com/problems/shuffle-an-array/description/

Shuffle the arrary: 
Starting from end of array, for each element j, choose a random value in [0, j] and swap it with element j.
*/

// solution 1:
int[] arr;
int[] origin;

public Solution(int[] nums) {
    arr = nums;
    origin = nums.clone();
}

/** Resets the array to its original configuration and return it. */
public int[] reset() {
    return origin.clone();
}

/** Returns a random shuffling of the array. */
public int[] shuffle() {
    for (int last = arr.length-1; last >0; last--) {
        //choose a random location among [0 ... last]
        int rand = (int) (Math.random() * (last+1));
        //swap this with the current last
        int tmp = arr[last];
        arr[last] = arr[rand];
        arr[rand] = tmp;
    }
    return arr;
}

/*
 * Shuffle a given arrary
 *
 * Author: Qing "Matt" Zhang
 * https://sites.google.com/site/mattzhangcube/home/coding
 */

public class shuffle {

    public static int[] shuffleArr(int a[]) {
        for (int last = a.length-1; last >0; last--) {
            //choose a random location among [0 ... last]
            int rand = (int) (Math.random() * (last+1));
            //swap this with the current last
            int tmp = a[last];
            a[last] = a[rand];
            a[rand] = tmp;
        }
        return a;
    }

    static final int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

    public static void main(String args[]) {
        int newa[] = shuffleArr(a);
        for (int i = 0; i < newa.length; i++)
            System.out.print(newa[i] + ", ");
    }
}


