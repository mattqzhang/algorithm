/*
 * Insertiong Sort
 * Author: Qing "Matt" Zhang
 * https://sites.google.com/site/mattzhangcube/home/coding

- Insertion sort:
    Idea: Assume A[1…j-1] already sorted, insert A[j].
    Complexity: N^2
    Insertion sort is often useful in solving some linked list related problems.
*/

package Sorting;

public class insertionSort {

    /*
     * Insertion sort: (Assume A[1…j-1] already sorted, insert A[j])
     */
    public static void InsertSort(int[] inArray) {
        int length = inArray.length;
        for (int j = 1; j < length; j++) {
            int x = inArray[j];
            int i = j - 1;
            while ((i >= 0) && (inArray[i] > x)) {
                inArray[i + 1] = inArray[i];
                i--;
            }
            inArray[i + 1] = x;
        }
    }

    /***********************************
     * Testing
     ***********************************/
    static final int inArray[] = { 2, 8, 6, 3, 9, 4, 10, 1, 7, 5 };

    // static final int inArray[] = {11, 2, 8, 15, 6, 3, 13, 9, 4, 14, 10, 1,
    // 16, 7, 5, 12};

    public static void main(String[] args) {
        int length = inArray.length;
        int myArray[] = new int[length];

        /* Insertion Sort */
        System.arraycopy(inArray, 0, myArray, 0, length);
        InsertSort(myArray);

        System.out.println("Insertion Sort result:");
        for (int i = 0; i < myArray.length; i++) {
            System.out.print(myArray[i] + " ");
        }
        System.out.println("");

        System.out.println("done");
    }
}

