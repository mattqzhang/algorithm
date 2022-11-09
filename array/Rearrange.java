/*
Rearrange Array
Given an array arr[] of size n where every element is in range from 0 to n-1.
Rearrange a given array so that Arr[i] becomes Arr[Arr[i]] with O(1) extra space.

https://www.geeksforgeeks.org/rearrange-given-array-place/
*/

// The function to rearrange an array in-place so that arr[i]
// becomes arr[arr[i]].
static void rearrange(int arr[], int n)
{
    // First step: Increase all values by (arr[arr[i]]%n)*n
    // After the increment operation of first step, every element holds both old values and new values.
    // Old value can be obtained by arr[i]%n and new value can be obtained by arr[i]/n.
    // (arr[i] + (arr[arr[i]] % n) * n) / n = arr[arr[i]]%n = arr[arr[i]]
    // we need the %n, because the arr[i] are already new values, so we need to get old values first.
    for (int i = 0; i < n; i++)
        arr[i] += arr[arr[i]]%n * n;

    // Second Step: Divide all values by n
    for (int i = 0; i < n; i++)
        arr[i] /= n;
}

// A utility function to print an array of size n
static void printArr(int arr[], int n)
{
    for (int i = 0; i < n; i++)
        System.out.print(arr[i] + " ");
    System.out.println("");
}

/* Driver program to test above functions */
public static void main(String[] args)
{
    int arr[] = {3, 2, 0, 1};
    int n = arr.length;

    System.out.println("Given Array is :");
    printArr(arr, n);

    rearrange(arr, n);

    System.out.println("Modified Array is :");
    printArr(arr, n);
}
