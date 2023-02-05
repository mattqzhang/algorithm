/*
Add binary strings
Given two binary strings, return their sum (also a binary string). 
*/

public static String addBinary(String s1, String s2) {
    int i = s1.length() - 1;
    int j = s2.length() - 1;
    if (i == -1)
        return s2;
    if (j == -1)
        return s1;

    StringBuilder sb = new StringBuilder();
    int carry = 0;

    // note it's OR relation here, we finish loop until both are done
    while (i >= 0 || j >= 0) {
        // if one string is already done, return 0
        int a = (i < 0 || s1.charAt(i) == '0') ? 0 : 1;
        int b = (j < 0 || s2.charAt(j) == '0') ? 0 : 1;
        int sum = a + b + carry;
        carry = sum / 2;
        sum = sum % 2;
        sb.insert(0, sum);
        i--;
        j--;
    }
    if(carry > 0)
        sb.insert(0, 1);
    return sb.toString();
}


/* Driver program to test above functions */
public static void main(String[] args)
{
    String a = "101";
    String b = "110";
    System.out.println(addBinary(a, b));

    System.out.println("done");

}
