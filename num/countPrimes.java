/*
Count Primes
Given an integer n, return the number of prime numbers that are strictly less than n.

lc 204
https://leetcode.com/problems/count-primes/description/
*/

    public int countPrimes(int n) {
        if (n<=2) return 0;

        // 0: prime / not visited, 1: not prime.
        int arr[] = new int[n];
        arr[0] = 1;
        arr[1] = 1;

        for (int i=2; i<n; i++) {
            // not visited, it's a prime
            if (arr[i] == 0) {                
                // mark all its multipliers, only need to check from k=i, as previous ones has been checked
                for (int k = i; k <= n / i; k++) {
                    if (i*k < n)
                        arr[i * k] = 1;
                }
            }
        }
        int ct = 0;
        for (int i=2; i<n; i++) {
            if (arr[i] == 0) ct++;
        }
        return ct;        
    }
