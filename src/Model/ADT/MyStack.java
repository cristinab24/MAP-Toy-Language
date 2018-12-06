package Model.ADT;

import java.util.Stack;
import Exception.MyStackException;

public class MyStack<T> implements IMyStack<T> {
    private Stack<T> stack;

    public MyStack() {
        this.stack = new Stack<>();
    }

    public T pop()throws MyStackException {
        if(stack.isEmpty())
            throw new MyStackException("Stack is empty");
        return stack.pop();
    }

    public void push(T v){
        stack.push(v);
    }

    /*public T peek() throws MyStackException{
        if(stack.isEmpty())
            throw new MyStackException("Stack is empty");
        return stack.peek();
    }*/

    public boolean empty(){
        return stack.empty();
    }

    /*public int search(T v){
        return stack.search(v);
    }*/

    public String toString(){
        StringBuilder s= new StringBuilder();
        for(T v: stack){
            s.append(v.toString()).append("\r\n");
        }
        return s.toString();
    }
}
