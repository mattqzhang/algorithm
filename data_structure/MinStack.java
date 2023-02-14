/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.

lc 155
https://leetcode.com/problems/min-stack/description/
*/

class MinStack {
    Stack<Integer> stack;
    int min;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        stack.push(x);
        min = Math.min(x, min);
    }
    
    public void pop() {
        int x = stack.pop();
        if (x == min) {
            min = Integer.MAX_VALUE;
            for (Integer i:stack) {
                min = Math.min(i, min);
            }
        }
    }
    
    public int top() {
        return stack.size() == 0 ? 0 : stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}
