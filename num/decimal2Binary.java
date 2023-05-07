/*
Convert a decimal to binary
*/

    public static String decimalToBinary(int n) {
        if (n == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int rem = n % 2;
            sb.insert(0, rem);
            n /= 2;
        }
        return sb.toString();
    }


// use bit shifting

    public static String decimalToBinary(int n) {
        if (n == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int rem = n & 1;
            n >>= 1;
            sb.insert(0, rem);
        }
        return sb.toString();
    }
