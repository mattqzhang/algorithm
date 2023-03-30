/*
Fizz Buzz
Given an integer n, return a string array answer (1-indexed) where:

answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
answer[i] == "Fizz" if i is divisible by 3.
answer[i] == "Buzz" if i is divisible by 5.
answer[i] == i (as a string) if none of the above conditions are true.


lc 412
https://leetcode.com/problems/fizz-buzz/description/
*/

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> res = new LinkedList<>();
        for (int i=1; i <= n; i++) {
            if (i % 15 == 0)
                res.add("FizzBuzz");
            else if (i % 3 == 0)
                res.add("Fizz");
            else if (i % 5 == 0)
                res.add("Buzz");
            else
                res.add(Integer.toString(i));
        }
        return res;
    }
}
