/*
Read N Characters Given Read4
int read4(buf) : write to buf, returns actually size read
*/

public class ReadN extends Reader4 {
    char[] cache = new char[4];
    int cacheIdx = 0;
    int num = 0;

    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int ct = 0;

        while (ct < n){
            // we need a new call to read4
            if(cacheIdx == num){
                num = read4(cache);
                cacheIdx = 0;
                // enf of file
                if(num == 0)
                    return ct;
            }
            // read cache into buf
            buf[ct++] = cache[cacheIdx++];
        }
        return ct;
    }

}
