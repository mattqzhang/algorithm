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

    // using two stacks, one for data, and one for min
    Stack<Integer> dataSt;
    Stack<Integer> minSt;

    public MinStack() {
        dataSt = new Stack();
        minSt = new Stack();
    }
    
    public void push(int val) {
        dataSt.push(val);
        if (minSt.isEmpty() || val <= minSt.peek())
            minSt.push(val);
    }
    
    public void pop() {
        int val = dataSt.pop();
        if (val == minSt.peek())
            minSt.pop();
    }
    
    public int top() {
        return dataSt.peek();
    }
    
    public int getMin() {
        return minSt.peek();
    }
}
