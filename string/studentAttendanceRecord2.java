/*
Student Attendance Record II

lc 552
https://leetcode.com/problems/student-attendance-record-ii/description/
*/


    static final int M = 1000000007;

    public int checkRecord(int n) {
        long[] PorL = new long[n + 1]; // ending with P or L, no A
        long[] P = new long[n + 1]; // ending with P, no A

        // base cases
        PorL[0] = P[0] = 1;
        // day 1
        PorL[1] = 2; P[1] = 1;

        for (int i = 2; i <= n; i++) {
            P[i] = PorL[i - 1];     // append P
            PorL[i] = (P[i] + P[i - 1] + P[i - 2]) % M;  // append L to P[i - 1], or LL to P[i - 2]
        }

        long res = PorL[n];
        // inserting A into (n-1)-length strings
        for (int i = 0; i < n; i++) {
            // insert A after i, then left has i, right has n-1-i
            long s = (PorL[i] * PorL[n - i - 1]) % M;
            res = (res + s) % M;
        }

        return (int) res;
    }


   // solution 2: separate computation for P and L
 
   static final int mod = (int) (1e9+7);

    public int checkRecord(int n){
        long[] P = new long[n+1]; //end with P w/o A
        long[] L = new long[n+1]; //end with L w/o A
        P[0] = P[1] = L[1] = 1;

        for(int i = 2; i <= n; i++){
            P[i] = (P[i-1] + L[i-1]) % mod; // append P
            L[i] = (P[i-1] + P[i-2]) % mod; // P[i-1] + L or P[i-2] + LL
        }
        long res = (P[n] + L[n]) % mod;

        // insert A after i, then left has i, right has n-1-i
        for(int i = 0; i < n; i++){ 
            long s = ((P[i] + L[i])%mod * (P[n-i-1] + L[n-i-1])%mod )% mod;
            res = (res + s) % mod;
        }
        return (int) res;
    }

