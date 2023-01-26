/*
1. Reverse all bits in a int number: xor with all F, or simply ~x

2. Reverse the order of bits in an int number: I have shown 4 ways to do it:
*/


public class reverseBit {

    /*
     * Reverse all bits in an int number
     */

    static int rev_bit(int v) {
        return (v ^ 0xFFFFFFFF);
        // another way is to return ~v;
    }

    /*********************************************************************/
    /*
     * Reverse the order of all bits in an int number
     */

    // version 1: get each bit from lsb side of v,
    //             and move to the msb side of result
    static int rev_bitorder_v1(int v) {
        int result = 0;

        int ct = 0;
        while (v > 0) {
            int i = v & 1;
            result += i << (31 - ct);
            v >>= 1;
            ct++;
        }

        return result;
    }

    // version 2: get each bit from lsb, then left shift result and add it
    static int rev_bitorder_v2(int v) {
        int result = 0;

        int ct = 32;
        // note that the condition cannot be simply v>0 as above
        // as we always need to shift result 31 times.
        while (ct > 0) {
            result <<= 1;            
            result |= v & 1;
            // or: result += v & 1;
            v >>= 1;
            ct--;
        }

        return result;
    }

    // version 3: swap bit i with 31- i, if they're different
    static int swapBits(int x, int i, int j) {
        int lo = ((x >> i) & 1); // i-th bit of x
        int hi = ((x >> j) & 1); // j-th bit of x

        if ((lo ^ hi) != 0) { // exchange if different
            x ^= ((1 << i) | (1 << j));
        }

        return x;
    }

    static int rev_bitorder_v3(int v) {
        for (int i = 0; i < 16; i++)
            v = swapBits(v, i, 31 - i);

        return v;
    }

    // version 4: log(n) algorithm using masking, divide and conquer
    static int rev_bitorder_v4(int x) {
        x = ((x & 0x55555555) << 1) | ((x & 0xAAAAAAAA) >> 1);
        x = ((x & 0x33333333) << 2) | ((x & 0xCCCCCCCC) >> 2);
        x = ((x & 0x0F0F0F0F) << 4) | ((x & 0xF0F0F0F0) >> 4);
        x = ((x & 0x00FF00FF) << 8) | ((x & 0xFF00FF00) >> 8);
        x = ((x & 0x0000FFFF) << 16) | ((x & 0xFFFF0000) >> 16);
        return x;
    }

    public static void main(String[] args) {

        int v = 150; // 10010110b
        System.out.println("initial value: \n\t" + Integer.toBinaryString(v));

        /*********************************************************************/
        // reverse all bits

        // 1101001b = 105
        int rev = rev_bit(v);
        System.out.println("reverse bit: " + rev + ", binary is: \n\t"
                + Integer.toBinaryString(rev));

        rev = ~v;
        System.out.println("reverse bit in one op: " + rev
                + ", binary is: \n\t" + Integer.toBinaryString(rev));

        /*********************************************************************/
        // reverse bit order

        // 0110, 1001, 0..0 (24 of them) = 1761607680
        rev = rev_bitorder_v1(v);
        System.out.println("reverse order v1: " + rev + ", binary is: \n\t"
                + Integer.toBinaryString(rev));

        rev = rev_bitorder_v2(v);
        System.out.println("reverse order v2: " + rev + ", binary is: \n\t"
                + Integer.toBinaryString(rev));

        rev = rev_bitorder_v3(v);
        System.out.println("reverse order v3: " + rev + ", binary is: \n\t"
                + Integer.toBinaryString(rev));

        rev = rev_bitorder_v4(v);
        System.out.println("reverse order v4: " + rev + ", binary is: \n\t"
                + Integer.toBinaryString(rev));
    }

}
