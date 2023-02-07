/*
Valid Parenthesis
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

lc 20
https://leetcode.com/problems/valid-parentheses/
*/

boolean isPair(char c1, char c2){
    if ((c1 == '(' && c2 == ')') || (c1 == '[' && c2 == ']') || (c1=='{' && c2 == '}'))
        return true;
    else
        return false;
}

public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    for(int i=0; i<s.length(); i++){
        if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
            stack.push(s.charAt(i));
        else if(s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}') {
            if(stack.isEmpty() || !isPair(stack.peek(), s.charAt(i)))
                return false;
            else
                stack.pop();
        }
    }
    return stack.isEmpty(); 
}


// remove the extra isPair call:

    public boolean isValid(String s) {
      Stack<Character> stack = new Stack<>();
      for(int i=0; i<s.length(); i++){
        if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
            stack.push(s.charAt(i));
        else if(s.charAt(i) == ')' ) {
            if (stack.isEmpty() || stack.pop() != '(') return false;
        } else if (s.charAt(i) == ']') {
            if (stack.isEmpty() || stack.pop() != '[') return false;
        } else if (s.charAt(i) == '}') {
            if (stack.isEmpty() || stack.pop() != '{') return false;
        }
      }
      return stack.isEmpty();
    }
