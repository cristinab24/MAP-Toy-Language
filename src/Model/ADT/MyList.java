package Model.ADT;

import java.util.*;
//import Exception.MyListException;

public class MyList<T> implements IMyList<T>{
    private Vector<T> list;

    public MyList() {
        this.list = new Vector<T>();
    }

    public void add(T v){
        list.add(v);
    }

    public T get(int idx) {
        return list.get(idx);
    }

    /*public int indexOf(T v){
        return list.indexOf(v);
    }*/

    /*public T remove(int idx)throws MyListException{
        if(list.isEmpty())
            throw new MyListException("List is empty. Can not remove element.");
        return list.remove(idx);
    }*/

    /*public void set(int idx, T v){
        list.set(idx, v);
    }*/

    public String toString(){
        StringBuilder s= new StringBuilder();
        for(T v: list){
            s.append(v.toString()).append("\r\n");
        }
        return s.toString();
    }
}
