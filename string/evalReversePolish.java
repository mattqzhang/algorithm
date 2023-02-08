/*
Validate Reverse Polish Notation

Example 1:
Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9

Example 2:
Input: tokens = ["4","13","5","/","+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6

lc 150
https://leetcode.com/problems/evaluate-reverse-polish-notation/
*/


public int evalRPN(String[] tokens) {
    Stack<Integer> stack = new Stack<>();

    for(int i = 0; i < tokens.length; ++i) {
        if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
            int secondOperand = stack.pop();
            int firstOperand = stack.pop();
            int res = -1;
            if(tokens[i].equals("+")) {
                res = firstOperand + secondOperand;
            } else if(tokens[i].equals("-")) {
                res = firstOperand - secondOperand;
            } else if(tokens[i].equals("/")) {
                res = firstOperand / secondOperand;
            } else {
                res = firstOperand * secondOperand;
            }
            stack.push(res);
        } else {
            stack.push(Integer.parseInt(tokens[i]));
        }
    }
    return stack.pop();
}
