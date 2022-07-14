// Given unsorted array, and use binary search on it directly.
// Some values will not be able to find. Identify those values.
public static void CheckHidden(int[] data, boolean[] hidden,
              int lo, int hi, int min_bound, int max_bound) {
    if (lo > hi) {
        return;
    }

    int mid = (lo + hi) / 2;
    int value = data[mid];


    // 'true' means the value at mid cannot be found
    hidden[mid] = (value <= min_bound || value >= max_bound);

    CheckHidden(data, hidden, lo, mid-1, min_bound, Math.min(value, max_bound));
    CheckHidden(data, hidden, mid+1, hi, Math.max(min_bound, value), max_bound);
}

// Wrapper
public static void CheckHidden(int[] data, boolean[] hidden) {
    CheckHidden(data, hidden, 0, data.length - 1, Integer.MIN_VALUE, Integer.MAX_VALUE);
}

/* Driver program to test above functions */
public static void main(String[] args)
{
    //int[] nums = new int[] {2, 7, 9, 10, 1};
    int[] nums = new int[] {22, 92, 25, 16, 29, 15, 49, 22, 38, 61};
    boolean[] hidden = new boolean[nums.length];
    CheckHidden(nums, hidden);
    System.out.println(Arrays.toString(hidden));

    System.out.println("done");

}
