/*
Decode String
Given an encoded string, return its decoded string.
The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
Example: Input: s = "3[a]2[bc]" Output: "aaabcbc"  Input: s = "3[a2[c]]" Output: "accaccacc"

lc 394
https://leetcode.com/problems/decode-string/
*/

public String decodeString(String s) {
    int num = 0;
    int level = 0;

    // <level, string>: to store the string at each level
    Map<Integer, StringBuilder> map = new HashMap<>();
    map.put(0, new StringBuilder());

    // stack is to store the number multiplier for each level
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);

        if (Character.isDigit(c)) {
            // 10*num is to parse 2 or more digits like 321
            num = 10 * num + (int)(c-'0');
        } else if (c == '[') {
            level++;
            map.put(level, new StringBuilder());
            // every time goes in a new level, push the multiplier to stack
            // and reset num to 0
            if (num > 0) {
                stack.push(num);
                num = 0;
            }
        } else if (Character.isLetter(c)) {
            StringBuilder sb = map.get(level);
            sb.append(c);
        } else if (c == ']') {
            StringBuilder sb = map.get(level);
            level--;
            // get out of a level, get the multiplier, 
            // compute the repeated string
            int repeats = stack.pop();
            String tmp = sb.toString();
            String res = "";
            for (int k = 0; k < repeats; k++) {
                res += tmp;
            }
            // attach to this level
            map.get(level).append(res);
        }
    }
    return map.get(0).toString();
}
