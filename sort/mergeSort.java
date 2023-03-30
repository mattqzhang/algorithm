/*
 * Merge Sort, both recursive and non-recursive versions
 * Author: Qing "Matt" Zhang
 * https://sites.google.com/site/mattzhangcube/home/coding
- Merge sort:
    Idea:
    - Recurseive: If array has 0 element, do nothing; else split in half, merge sort both parts, then merge them.
    - Non-recursive merge sort: uses bottom-up merge sort. First merge every two consecutive values, then merge every two consecutive blocks. Note that the last block may contain arbitrary number of values.
    Complexity: NlogN
    Merge Sort is often useful for processing partitioned large data blocks.

lc 912
https://leetcode.com/problems/sort-an-array/description/

 */

package Sorting;

public class mergeSort {

    /***********************************
     * Merge Sort
     ***********************************/

    public static void Merge(int[] inArray, int left, int mid, int right) {
        // merge inArray [left..mid] and [mid+1 .. right]
        int num = right - left + 1;
        int result[] = new int[num];
        int idx = 0;
        int i = left;
        int j = mid + 1;
        while ((i <= mid) && (j <= right)) {
            if (inArray[i] <= inArray[j])
                result[idx++] = inArray[i++];
            else
                result[idx++] = inArray[j++];
        }
        while (i <= mid)
            result[idx++] = inArray[i++];
        while (j <= right)
            result[idx++] = inArray[j++];

        System.arraycopy(result, 0, inArray, left, num);
    }

    public static void MergeSort(int[] inArray, int left, int right) {
        if (left < right) {
            int mid = (int) (left + right) / 2;
            MergeSort(inArray, left, mid);
            MergeSort(inArray, mid + 1, right);
            // merge inArray [left..mid] and [mid+1 .. right]
            Merge(inArray, left, mid, right);
        }
    }

    public static void nonrec_MergeSort(int[] inArray) {
        int len = inArray.length;
        int step = 1;
        while (step < len) {
            int i = 0;
            int last = (int) (len - 1) / step;

            while (i <= last) {
                Merge(inArray, i * step, Math.min((i + 1) * step - 1, len - 1),
                        Math.min((i + 2) * step - 1, len - 1));
                i = i + 2;
            }
            step = step * 2;
        }

    }

    /***********************************
     * Testing
     ***********************************/
    // static int inArray[] = {2, 8, 6, 3, 9, 4, 10, 1, 7, 5};
    // static final int inArray[] = {11, 2, 8, 15, 6, 3, 13, 9, 4, 14, 10, 1, 7,
    // 5, 12};
    static final int inArray[] = { 5, 2, 6, 9, 3, 11, 1, 4, 8, 7, 10, 12 };

    public static void main(String[] args) {
        int length = inArray.length;
        int myArray[] = new int[length];

        /* Merge Sort */
        System.arraycopy(inArray, 0, myArray, 0, length);
        MergeSort(myArray, 0, length - 1);

        System.out.println("Merge Sort result:");
        for (int i = 0; i < myArray.length; i++) {
            System.out.print(myArray[i] + " ");
        }
        System.out.println("");

        /* non-recursive Merge Sort */
        int myArray1[] = new int[length];
        System.arraycopy(inArray, 0, myArray1, 0, length);
        nonrec_MergeSort(myArray1);
        System.out.println("Non-recursive Merge Sort result:");
        for (int i = 0; i < myArray1.length; i++) {
            System.out.print(myArray1[i] + " ");
        }
        System.out.println("");

        System.out.println("done");
    }

}

