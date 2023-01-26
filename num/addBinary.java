/*
Add two numbers represented as binary strings
https://www.geeksforgeeks.org/program-to-add-two-binary-strings/
https://gist.github.com/zac-xin/4381455
*/

static String addBinary(String s1, String s2){
    String result = "";

    int s = 0;
    int i = s1.length() - 1;
    int j = s2.length() - 1;

    while(i >= 0 || j >= 0 || s==1) {
        // add last digit
        s += (i >=0 ? s1.charAt(i) - '0' : 0);
        s += (j >=0 ? s2.charAt(j) - '0' : 0);

        // add digit to the front
        result = (char)(s % 2 + '0') + result;

        // carry
        s /= 2;

        i--;
        j--;
    }

    return result;
}
