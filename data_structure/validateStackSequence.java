/*
Validate Stack Sequences
Given two integer arrays pushed and popped each with distinct values, return true if this could have been the result of a sequence of push and pop operations on an initially empty stack, or false otherwise.

lc 946
https://leetcode.com/problems/validate-stack-sequences/description/
*/

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int idx = 0;
        // push all
        for (int i:pushed) {
            while (!st.isEmpty() && st.peek() == popped[idx]) {
                st.pop();
                idx++;
            }
            st.push(i);
        }
        // pop remaining
        while (!st.isEmpty() && idx < popped.length && st.peek() == popped[idx]) {
            st.pop();
            idx++;
        } 
        return st.isEmpty();
    }


// do it in one shot
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length != popped.length) return false;
        if (pushed.length == 0) return true;
        Stack<Integer> stack = new Stack<>();
        int idx = 0;
        // push, then try pop immediately as many as possible
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while(!stack.isEmpty() && stack.peek() == popped[idx]) {
                stack.pop();
                idx++;
            }
        }
        return stack.isEmpty();
    }
