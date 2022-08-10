/*
Fair Work Load: Given an array of elements, divide into K groups, so that
- elements in each group is continuous
- the maximum of the sum of each group is minimized
*/

import java.util.*;

/* Given an array of elements, divide into K groups, so that
 * - elements in each group is continuous
 * - the maximum of the sum of each group is minimized
 */
public class fairWorkLoad {

    static int getmax(int a, int b) {
        return a > b ? a : b;
    }

    static int getsum(int a[], int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += a[i];
        }
        return sum;
    }

    /************************************************************
     * Greedy algorithm to split into k partitions, we iterate over all possible
     * 1st cut, then compare with the remaining k-1 partitions which is computed
     * recursively.
     * */
    static int fairWorker_greedy(int a[], int start, int k) {
        int max = 0;
        int minSum = getsum(a, start, a.length - 1);

        if (k == 1)
            return minSum;

        // iterate over all the 1st cut point
        for (int i = start; i <= a.length - k; i++) {
            // sum of the first part
            int sum = getsum(a, start, i);
            // recursively compare with remaining part of k-1 partitions
            max = getmax(sum, fairWorker_greedy(a, i + 1, k - 1));
            // update global
            if (max < minSum)
                minSum = max;
        }
        return minSum;
    }

    /*************************************************************
     * binary search in the sum space
     * */
    // given the maxLoad for each partition, find the number of workers needed,
    // so that each worker's load doesn't exceed maxLoad.
    // Since each worker's job is assigned continuously,
    // we can find it in greedy way: add to each partition as long as it doesn't
    // exceed maxLoad
    static ArrayList<Integer> workSplit(int a[], int maxLoad) {
        ArrayList<Integer> cut = new ArrayList<Integer>();
        int load = a[0];
        int i = 1;
        while (i < a.length) {
            if (load + a[i] <= maxLoad) {
                load += a[i];
            } else {
                load = a[i];
                cut.add(i - 1);
            }
            i++;
        }

        return cut;
    }

    //
    static int fairWorker_bs_sum(int a[], int k) {
        // max element in the array
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max)
                max = a[i];
        }
        // lower bound of search space is the max element
        // (each element in its own partition)
        int lo = max;
        // higher end of search space is the sum of all elements (single
        // partition)
        int hi = getsum(a, 0, a.length - 1);

        // binary search the [lo, hi] range for the workload which accommodates
        // k workers.
        // until we have exactly k workers, and lo meets hi
        ArrayList<Integer> finalCut = new ArrayList();
        while (lo < hi) {
            int mid = (lo + hi) / 2;

            ArrayList<Integer> cut = workSplit(a, mid);
            int workerCt = cut.size() + 1;

            // have more available workers to use, we can decrease the sum
            // in each partition,
            // even if it needs "=k" workers if sum is in the range,
            // we can still see if we can reduce the upper bound of the maxLoad.
            if (workerCt <= k) {
                hi = mid;
                finalCut = cut;
            }
            // no solution within k workers if sum is in [lo, mid]
            // we we try the other half
            else
                lo = mid + 1;
        }
        System.out.println("final cut positions: " + finalCut);
        return lo;
    }

    public static void main(String[] args) {
        int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        // int a[] = {1, 2, 3, 4};
        int k = 3;

        int max = fairWorker_greedy(a, 0, k);
        System.out.println("greedy:        max = " + max);

        max = fairWorker_bs_sum(a, k);
        System.out.println("binary search sum:        max = " + max);
    }
}
