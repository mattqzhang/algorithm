/*
Bit Count: count the total number of set bits in a number's binary form.
There're several ways to do this:
- bit shifting, check last bit one by one
- mod 2, check remainder every time.
- for sparse bits, n &(n-1) is most effective.
*/

/* Count number of set bit in a number's binary form */
public class countOnes {
    static int count_shift(int val){
        int ct = 0;
        while(val > 0){
            ct += val & 1;
            val >>= 1;
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

    public static void main(String[] args) {
        int val = 321, ct=0;
        System.out.println("value is " + Integer.toBinaryString(val));

        ct = count_shift(val);
        System.out.println("count by shifting: " + ct);

        ct = count_shift(val);
        System.out.println("count by mod 2: " + ct);

        ct = count_shift(val);
        System.out.println("count sparse: " + ct);
    }
}
