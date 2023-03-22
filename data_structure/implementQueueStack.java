/*
Implement Queue using Stacks
Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).

lc 232
https://leetcode.com/problems/implement-queue-using-stacks/description/
*/

class MyQueue {
    Stack<Integer> s1;  // in stack
    Stack<Integer> s2;  // out stack

    public MyQueue() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }
    
    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
        if (s2.size() > 0) return s2.pop();
        // s2 is empty;
        while(!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        return s2.pop();
    }
    
    public int peek() {
        if (s2.size() > 0) return s2.peek();
        // s2 is empty;
        while(!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        return s2.peek();
    }
    
    public boolean empty() {
        return (s1.isEmpty() && s2.isEmpty());
    }
}
