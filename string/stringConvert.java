/*
Check if it's possible to convert one String to another
Given two strings s1 and s2(all letters in uppercase). Check if it is possible to convert s1 to s2 by performing following operations.  
1. Make some lowercase letters uppercase. 
2. Delete all the lowercase letters. 
Solve by DP.
*/

package com.string.mz;

public class stringConvert {

/*
function to check if a string can be converted to  another string by
performing following operations:
1. Make some lowercase letters uppercase.
2. Delete all the lowercase letters.
Solve by DP.
*/
static boolean canConvert(String s1, String s2) {
    // calculates length
    int n = s1.length();
    int m = s2.length();

    boolean dp[][] = new boolean[n + 1][m + 1];
    for (int i = 0; i <= n; i++) {
        for (int j = 0; j <= m; j++) {
            dp[i][j] = false;
        }
    }
    // mark 1st position as true, for null strings
    dp[0][0] = true;

    // two pointers to move forward, fill the DP matrix
    for (int i = 0; i < s1.length(); i++) {
        for (int j = 0; j <= s2.length(); j++) {

            // if possible for to convert i characters of s1 to j characters of s2
            if (dp[i][j]) {
                // if upper_case(s1[i]) == s2[j], it's a solution
                if (j < s2.length() &&
                        (Character.toUpperCase(s1.charAt(i)) == s2.charAt(j)))
                    dp[i + 1][j + 1] = true;

                // if s1 is not upper, then deletion of s1 is also possible
                if (!Character.isUpperCase(s1.charAt(i)))
                    dp[i + 1][j] = true;
            }
        }
    }

    return (dp[n][m]);
}

public static void main(String[] args) {

    String s1 = "daBcd";
    String s2 = "ABC";

    if (canConvert(s1, s2))
        System.out.println("Yes");
    else
        System.out.println("No");

    System.out.println("");

    System.out.println("done");
}
}
