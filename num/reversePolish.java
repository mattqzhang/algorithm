/*
Restore the Reverse Polish Notation. Reverse Polish is a postfix mathematical notation in which each operator immediately follows its operands.
The basic idea is: when you see a digit number, push it into stack. When you see an operator, pop a number from stack and append after the operator.
*/

/** Restore the Reverse Polish Notation (RPN) to normal order.
* Reverse Polish is a postfix mathematical notation in which each operator
* immediately follows its operands.
* Each operand may be a number or another expression.
* For example, 3 + 4 in Reverse Polish is 3 4 + and 2 * (4 + 1) would be
* written as 4 1 + 2 * or 2 4 1 + *
*
* Some sample ops:
* ["4", "1", "+", "2.5", "*"] -> ((4 + 1) * 2.5) -> 12.5
* ["5", "80", "40", "/", "+"] -> (5 + (80 / 40)) ->  7
*/
import java.util.*;

public class reversePolish {

    static boolean isDigit(String in){
        int start =0;
        int len = in.length();
        if(in.charAt(0) == '-')
            start ++;
       
        for(int i=start; i<len; i++){
            if((in.charAt(i)< '0' || in.charAt(i) > '9') && (in.charAt(i) != '.'))
                return false;                           
        }
        return true;
    }   
   
    static boolean isOperator(String in){
        if (in.length() != 1)
            return false;
        if (in.equals("+") || in.equals("-") || in.equals("*") || in.equals("/"))
            return true;
        return false;
    }
   
    static void revPolish(String[] ops){
        int len = ops.length;
        String clause = "";
        Stack<String> stk = new Stack<String>();
        boolean firstOp = true;
       
        for(int i=0; i<len; i++){
            if(isDigit(ops[i])){
                stk.push(ops[i]);           
            }else if(isOperator(ops[i])){   
                clause += ops[i] + stk.pop() + ")";               
                if(firstOp){
                    firstOp = false;
                    clause = "(" + stk.pop() + clause;                   
                }
                else
                    clause = "(" + clause;               
            }else
                throw new IllegalArgumentException();
        }
        System.out.println(clause);
    }
   
    public static void main(String[] args) {       
        String[] ops1 = {"4", "1", "+", "2.5", "*"};
        revPolish(ops1);
       
        String[] ops2 = {"5", "80", "40", "/", "+"};       
        revPolish(ops2);

    }
}

