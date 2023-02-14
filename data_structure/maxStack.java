/*
Max Stack
Design a max stack that supports push, pop, top, peekMax and popMax.
*/

Stack<Integer> stkMax;
Stack<Integer> stkData;

/** initialize your data structure here. */
public MaxStack() {
    stkMax = new Stack<>();
    stkData = new Stack<>();
}

// push into data stack
// for max stack, push the value if it's bigger than current max, otherwise push current max
public void push(int x) {
    stkData.push(x);
    stkMax.push( (stkMax.isEmpty() || x >= stkMax.peek())? x : stkMax.peek());
}

public int pop() {
    stkMax.pop();
    return stkData.pop();
}

public int top() {
    return stkData.peek();
}

public int peekMax() {
    return stkMax.peek();
}

public int popMax() {
    int max = stkMax.peek();
    Stack<Integer> buffer = new Stack<>();
    while(stkData.peek() != max)
        buffer.push(pop());
    pop();
    while(!buffer.isEmpty())
        push(buffer.pop());

    return max;
}
