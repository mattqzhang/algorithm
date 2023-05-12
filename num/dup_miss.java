/*
Duplicate and missing: If one is duplicate, and one is missing:
We can compute the following two equations:
n(n+1)/2 - sum(arr[i]) = d – m
n(n+1)(2n+1)/6 - sum(arr[i])^2 = d^2 - m^2
Or, we can go through the array, and put each value i in the corresponding a[i]. Duplicate is the one that has appear twice, and miss is the one a[i] !=i
*/


/* Values 0 to n-1 each appear once, except one appear twice and one is missing.
 * Find the duplicate one and the missing one. 
 */

    static void swap(int a[], int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    static void dupmiss(int arr[]) {
        int i = 0, n = arr.length;
        int dup = -1, miss = -1;
        // for each j=arr[i], move it to arr[j]
        for (i = 0; i < n; i++) {
            while (i != arr[i]) {
                // already placed the number there, must be a dup
                if (arr[arr[i]] == arr[i]){
                    dup = arr[i];
                    i++;
                    break;
                } else
                    // move j=arr[i] to arr[j]
                    swap(arr, i, arr[i]);
            }
        }
        System.out.println("dup is " + dup);
       
        for (i = 0; i < n; i++) {
            if (i != arr[i]) {
                miss = i;
                System.out.println("miss is " + miss);               
            }
        }
    }


/* shifted index: given arr size n, in range 1 .. n, one missing and one duplicate
   find the duplicate and missing one.
 */
static void findMiss(int arr[], int n){
    int a[] = new int[n];

    for (int i = 0; i < arr.length; i++){
        int val = arr[i];
        if(a[val-1] != 0 )
            System.out.println("duplicate: " + val);
        else
            a[val-1] = 1;
    }
    for (int i=0; i<a.length; i++){
        if (a[i] == 0)
            System.out.println("missing: " + (i+1));
    }
}
