/*
Print Balanced Parenthesis
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

lc 22
https://leetcode.com/problems/generate-parentheses/description/
*/

class Solution {

    public void generateParenthesis(List<String> res, String str, int n, int open, int close) {
        if (close == n) {
            res.add(str);
            return;
        }

        // at every step, try to close an existing one, and/or open a new one
        // can open a new pair
        if (open < n) {
            String str1 = str + "(";
            generateParenthesis (res, str1, n, open+1, close);
        }
        // can close a pair
        if (open > close) {
            String str2 = str + ")";
            generateParenthesis (res, str2, n, open, close+1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        generateParenthesis(res, "", n, 0, 0);
        return res;
    }
}



// Function that print all combinations of balanced parentheses
// open: stores the count of opening parenthesis
// close: stores the count of closing parenthesis
static void printParenthesis(char str[], int pos, int n, int open, int close)
{
    // terminal case
    if(close == n){
        // print the possible combinations
        for(int i=0;i<str.length;i++)
            System.out.print(str[i]);
        System.out.println();
        return;
    }else{
        // close existing open
        if(open > close) {
            str[pos] = '}';
            printParenthesis(str, pos+1, n, open, close+1);
        }
        // nested open
        if(open < n) {
            str[pos] = '{';
            printParenthesis(str, pos+1, n, open+1, close);
        }
    }
}

// Wrapper over _printParenthesis()
static void printParenthesis(char str[], int n)
{
    if(n > 0)
        printParenthesis(str, 0, n, 0, 0);
    return;
}

// driver program
public static void main (String[] args)
{
    int n = 3;
    char[] str = new char[2 * n];
    printParenthesis(str, n);
}
