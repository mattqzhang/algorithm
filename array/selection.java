/*
Find the k-th largest elements in an unsorted array.
General selection: apply the finding of max/min algorithm k times. O(nk)
Partition-based: apply the partition algorithm as in quick sort. But here after find the index of the pivot element, we know which partition the k-th one falls into. So O(n)  expected, and worst case O(n^2).
There's also a linear O(n) algorithm: we partition the array into subarrays of size 5, use the medium of the medium of these arrays as pivot element, and do partition.

lc 215
https://leetcode.com/problems/kth-largest-element-in-an-array/description/
*/


    // Solution 1: general selection algorithm, in place algorithm
    // similar to bubble sort
    static int selectk(int a[], int k) {
        int len = a.length;
        assert (k > 0 && k < len + 1);

        for (int i = 0; i < k; i++) {
            int max = a[len - 1 - i];
            for (int j = 0; j < len - 1 - i; j++) {
                if (a[j] > max) {
                    max = a[j];
                    a[j] = a[len - 1 - i];
                    a[len - 1 - i] = max;
                }
            }
        }
        System.out.println("after selection: " + Arrays.toString(a));
        return a[len - k];
    }



    // Solution 2: use partition algorithm
    static void swap(int a[], int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    static int partition(int a[], int left, int right) {
        assert (left <= right);
        int pivot = a[right];
        int i = left - 1;
        for (int j = 0; j < right; j++) {
            if (a[j] < pivot) {
                swap(a, ++i, j);
            }
        }
        swap(a, ++i, right);
        return i;
    }

    static int selectk_partition(int a[], int left, int right, int k) {
        int idx = partition(a, left, right);
        if (idx == right - k + 1)
            return a[idx];

        if (idx < right - k + 1)
            return selectk_partition(a, idx + 1, right, k);
        else
            return selectk_partition(a, left, idx - 1, k - (right - idx + 1));
    }



    // solution 3: use priority queue 
 
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        for (int i:nums) {
            q.offer(i);
            // remove the smallest one, and keep pq size to k
            if (q.size() > k) {
                q.poll();
            }
        }
        // now pq size is k, and root is the k-th one
        return q.poll();
    }
