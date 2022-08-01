/*
Return true if and only if the given array A is monotonic.
*/

// solution 1:

public boolean isMonotonic(int[] A) {
    int n = A.length;
    if(n==0 || n == 1)
        return true;

    // go through the "=" ones to find first unequal
    int i=1;
    while(i<n && A[i] == A[i-1])
        i++;
    if(i == n)
        return true;

    // decide inc/dec
    boolean inc = A[i-1] < A[i] ? true : false;

    for(int j=i+1; j<n; j++){
        if(inc && A[j] < A[j-1] || !inc && A[j] > A[j-1])
            return false;
    }
    return true;
}

// solution 2:

public boolean isMonotonic(int[] A) {
    boolean increasing = true;
    boolean decreasing = true;
    for (int i = 0; i < A.length - 1; ++i) {
        if (A[i] > A[i+1])
            increasing = false;
        if (A[i] < A[i+1])
            decreasing = false;
    }

    // return true if you always get inc or dec, then this will be false||true
    // otherwise you get both false
    return increasing || decreasing;
}
