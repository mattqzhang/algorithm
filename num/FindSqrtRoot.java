/*
Find square root
Find the square root of a perfect square number n, using binary search
*/

static int findSqrtRoot(int n){
    if (n==0 || n == 1)
        return n;

    int start = 1, end = n;
    while(start <= end) {
        int mid = (start + end) / 2;
        if(mid * mid == n)
            return mid;
        else if (mid * mid > n)
            end = mid - 1;
        else
            start = mid + 1;
    }
    // not a perfect square number
    return -1;
}
