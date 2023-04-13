/*
* Given an array, choose m of them
* so that the difference of the minimum and maximum is minimized.
* */
static int findMinDiff(int arr[], int m)
{
    int n = arr.length;
    if (m == 0 || n == 0)
        return 0;
    // partitions cannot be more than number of elements in array
    if (n < m)
        return -1;
    // Sort the array
    Arrays.sort(arr);
    int min_diff = Integer.MAX_VALUE;
    // Find the subarray of size m such that difference between
    // last (maximum in case of sorted) and first (minimum in
    // case of sorted) elements of subarray is minimum.
    int first = 0, last = 0;
    for (int i = 0; i + m - 1 < n; i++)
    {
        int diff = arr[i+m-1] - arr[i];
        if (diff < min_diff)
        {
            min_diff = diff;
            first = i;
            last = i + m - 1;
        }
    }
    return (arr[last] - arr[first]);
}
