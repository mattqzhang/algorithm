/*
Multiply integer strings
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
*/

public static String multiply(String num1, String num2) {
    int len1 = num1.length(), len2 = num2.length();
    if(len1 == 0 || len2 == 0)
        return "0";

    // result should fit in len1 + len2
    int[] res = new int[len1 + len2];
    for (int i = 0; i < len1; i++) {
        for (int j = 0; j < len2; j++) {
            int v1 = num1.charAt(len1-1-i) - '0';
            int v2 = num2.charAt(len2-1-j) - '0';
            res[i + j] +=  v1 * v2 ;
        }
    }

    // fix all carries. Note that res is reverse order of actual numbers.
    for (int i = 0; i < len1 + len2; i++) {
        while (res[i] >9) {
            res[i + 1] += res[i] / 10;
            res[i] = res[i] % 10;
        }
    }
    StringBuilder ans=new StringBuilder();
    for (int i = len1 + len2-1; i >=0; i--) {
        ans.append(res[i]);
    }
    //remove 1st '0'
    return ans.charAt(0) == '0' && ans.length() != 1 ? ans.substring(1) : ans.toString();
}
