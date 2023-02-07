/*
Minimum Removal to make valid parentheses 
Given a string s of '(' , ')' and lowercase English characters. 
Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

lc 1249
https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
*/

public String minRemoveToMakeValid(String s) {
    // index of parentheses to be removed
    HashSet<Integer> hs = new HashSet<>();
    Stack<Integer> st = new Stack<>();

    for(int i=0; i<s.length(); i++){
        if(s.charAt(i) == '(')
            st.push(i);
        else if(s.charAt(i) == ')') {
            if(!st.isEmpty())
                st.pop();
            else
                hs.add(i);
        }
    }
    // unmatched, add to be removed
    while(!st.isEmpty()){
        hs.add(st.pop());
    }
    StringBuilder sb = new StringBuilder();
    for(int i=0; i < s.length(); i++){
        if(!hs.contains(i))
            sb.append(s.charAt(i));
    }
    return sb.toString();
}

