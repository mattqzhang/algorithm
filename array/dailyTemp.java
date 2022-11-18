/*
lc 739
https://leetcode.com/problems/daily-temperatures/

Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.
*/

public int[] dailyTemperatures(int[] T) {
    int[] ans = new int[T.length];
    Stack<Integer> stack = new Stack();
    // reverse check from end
    for (int i = T.length - 1; i >= 0; --i) {
        // current value is bigger or equal to stack top, pop smaller ones
        while (!stack.isEmpty() && T[i] >= T[stack.peek()])
            stack.pop();
        // now T[i] < T[stack.peek()]
        ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
        // push current one
        stack.push(i);
    }
    return ans;
}

