/*
Bit Count: count the total number of set bits in a number's binary form.
There're several ways to do this:
- bit shifting, check last bit one by one
- mod 2, check remainder every time.
- for sparse bits, n &(n-1) is most effective.

lc 191
https://leetcode.com/problems/number-of-1-bits/description/
*/

    // treat n as an unsigned value
    public int hammingWeight(int n) {
        int ct = 0;
        while (n !=0) {
            if ((n & 1) == 1) ct++;
            n >>>= 1;    // unsigned right shift
        }
        return ct;
    }



    /* Count number of set bit in a number's binary form */
    static int count_shift(int val){
        int ct = 0;
        while(val > 0){
            ct += val & 1;
            val >>= 1;   // note that we don't need >>>, as we test val>0 (all 1's are negavie)
        }
        return ct;
    }

    /* count number of set bits by mod 2 */
    static int count_mod(int val){
        int ct = 0;
        while(val >0){
            ct += val % 2;
            val /= 2;
        }
        return ct;
    }

    /* for sparse set bits, this is very efficient */
    static int count_sparse(int val){
        int ct = 0;
        while(val > 0){
            val &= (val - 1);
            ct ++;
        }
        return ct;
    }

