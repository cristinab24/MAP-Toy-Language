package Model.ADT;
import Exception.MyDictionaryException;

import java.util.Collection;
import java.util.Dictionary;
import java.util.Map;

public interface IMyDictionary<K, V> {
    void put(K key, V val);
    boolean containsKey(K key);
    V get(K key) throws MyDictionaryException;
    void remove(K key) throws MyDictionaryException;
    //void remove(K key, V value) throws MyDictionaryException;
    String toString();
    void update(K key, V val) throws MyDictionaryException;
    Collection<V> getValues();
    K getKeyByValue(V value);
    Map getContent();
    void setContent(Map newDict);
}
