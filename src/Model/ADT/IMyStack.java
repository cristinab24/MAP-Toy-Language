package Model.ADT;
import Exception.MyStackException;

public interface IMyStack<T> {
    T pop() throws MyStackException;
    void push(T v);
    //T peek() throws MyStackException;
    boolean empty();
    //int search(T v);
    String toString();
}
