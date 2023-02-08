/*
Backspace String Compare
Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

lc 844
https://leetcode.com/problems/backspace-string-compare/
*/

public String buildString(String S) {
    Stack<Character> st1 = new Stack<>();
    // read into stack, pop when sees "#"
    for (int i = 0; i < S.length(); i++) {
        char c = S.charAt(i);
        if (c == '#') {
            if(!st1.isEmpty()) 
               st1.pop();
        } else
            st1.push(c);
    }
    // output stack to string
    String res = "";
    while(!st1.isEmpty())
        res = st1.pop() + res;
    return res;
}

public boolean backspaceCompare(String S, String T) {
    String S1 = buildString(S);
    String T1 = buildString(T);
    return S1.equals(T1);
}
