/*
Ways to Decode
*/

/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:
'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits, determine the total number of ways to decode it.
 */
public static int numDecodings(String s) {
    if(s.length() == 0)
        return 0;

    int[] res = new int[s.length() + 1];
    res[0] = 1;   // base

    // go through each s[i], note that ct of adding s[i] is saved in res[i+1]
    for(int i = 0; i < s.length(); i++) {
        // s[i] is alone, then same ct as previous ct
        res[i + 1] = res[i];

        // s[i] can start from s[i-1], then add the ct for s[i-2], which is res[i-1]
        // basically in this case, current ct res[i+1] = res[i] + res[i-1]
        if(i > 0 && ((s.charAt(i - 1) == '1')  || ( s.charAt(i - 1) == '2' && s.charAt(i) <= '6'))) {
            res[i + 1] += res[i - 1];
        }

    }

    return res[s.length()];
}
