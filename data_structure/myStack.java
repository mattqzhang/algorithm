/*
Implement a Stack
Implement the following functionality: push(), pop(), peek(), isEmpty()
*/

public class myStack<T> {

    private class Node{
        T data;
        Node next;

        Node(T data){
            this.data = data;
        }
    }

    int size;
    Node top;

    public myStack(){
        top = null;
        size = 0;
    }

    public boolean isEmpty(){
        return (size == 0);
    }

    public T peek(){
        return (top == null) ? null : top.data;
    }

    public void push(T data){
        Node entry = new Node(data);
        entry.next = top;
        top = entry;
        size++;
    }

    public T pop(){
        if (top == null)
            return null;
        Node entry = top;
        top = top.next;
        size --;
        return entry.data;
    }
}
