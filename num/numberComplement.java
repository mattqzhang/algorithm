/*
Number Complement

lc 476
https://leetcode.com/problems/number-complement/description/
*/

    public int findComplement(int num) {
        int len = 0, val = num;
        // find length of the binary form
        while (val > 0) {
            val >>= 1;
            len ++;
        }
        // create 11...1 to bitwise xor with num
        // example: len=3: 1000 - 1 = 111
        int mask = (1 << len) - 1;
        return mask ^ num;     
    }
