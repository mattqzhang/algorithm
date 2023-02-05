/*
Add Two String numbers
Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
*/

public String addStrings(String num1, String num2) {
    int len1 = num1.length();
    int len2 = num2.length();
    int carry = 0;
    String strsum = "";

    for(int i=0; i<Math.max(len1, len2); i++){
        int a = (i < len1 ? num1.charAt(len1 - 1 -i) - '0' : 0);
        int b = (i < len2 ? num2.charAt(len2 - 1 -i) - '0' : 0);
        int sum = a + b + carry;
        carry = sum/10;
        int val = sum % 10;
        strsum = val + strsum;
    }
    if(carry == 1)
        strsum = "1" + strsum;
    return strsum;
}
