/*
Find the median of an unsorted array

Solution 1: use partition algorithm as the one used in quick sort.

Solution 2: use two heaps, one min heap and one max heap, and their sizes differ by at most one. Dynamically adjust the heaps so that all values in the min heap is bigger than the max heap (root of min heap is bigger than root of max heap). Medium is then the average of min root and max root(if same size), or the max root (if N_max = N_min +1). This method can be used for dynamic streams data.

Solution 3: use Priority Queue, similar to the two heaps: all values in q1 < all values in q2, and size differ by at most 1.
*/

int findMedium(PriorityQueue q1, PriorityQueue q2) {
    // q1 is the max queue, to store the smaller half
    //    as PQ is sorted min to max, we multiple by (-1) to the max value at the head.
    // q2 is the min queue, to store the bigger half
    int len1 = q1.size();
    int len2 = q2.size();
    if (len1 > len2) {
        int v1 = (int)q1.peek() * (-1);
        return v1;
    } else if (len2 > len1) {
        return (int) q2.peek();
    } else { // same length
        if (len1 == 0)
            return 0;
        int v1 = (int)q1.peek() * (-1);
        int v2 = (int)q2.peek();
        return (int) (v2 + v2) / 2;
    }
}

