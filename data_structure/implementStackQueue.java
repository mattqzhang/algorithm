/*
Implement a last-in-first-out (LIFO) stack using only two queues. 
The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).

lc 225
https://leetcode.com/problems/implement-stack-using-queues/description/
*/

// using two queues:
class MyStack {
    Queue<Integer> q1, q2;
    int top;

    public MyStack() {
        q1 = new LinkedList<Integer>();
        q2 = new LinkedList<Integer>();        
    }
    
    public void push(int x) {
        q1.add(x);
        top = x;
    }
    
    public int pop() {
        if (q1.size() == 1) {
            return q1.remove();
        }
        while (q1.size() >1 ) {
            top = q1.remove();
            q2.add(top);            
        }
        int res = q1.remove();
        q1 = q2;
        q2 = new LinkedList();
        return res;
    }
    
    public int top() {
        return top;
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}


/**** using one queue  ****/
// when push, add to queue, then move all elements in front behind it.

class MyStack {
    Queue<Integer> q;

    public MyStack() {
        q = new LinkedList<Integer>();        
    }
    
    public void push(int x) {
        int size = q.size();        
        q.add(x);
        while (size >0) {
            q.add(q.remove());
            size--;
        }
    }
    
    public int pop() {        
        return q.remove();        
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}

