package Model.ADT;

import java.util.*;

import Exception.MyDictionaryException;

public class MyDictionary<K, V> implements IMyDictionary<K, V> {
    private Map<K, V> dictionary;

    public MyDictionary() {
        this.dictionary = new HashMap<>();
    }

    public void put(K key, V val){
        dictionary.put(key, val);
    }

    public boolean containsKey(K key){
        return dictionary.containsKey(key);
    }

    public V get(K key) throws MyDictionaryException{
        if(!dictionary.containsKey(key))
            throw new MyDictionaryException("Key does not exist");
        return dictionary.get(key);
    }

    public void remove(K key)throws MyDictionaryException{
        if(!dictionary.containsKey(key))
            throw new MyDictionaryException("Key does not exist");
        dictionary.remove(key);
    }

    /*public void remove(K key, V value)throws MyDictionaryException{
        if(!dictionary.containsKey(key))
            throw new MyDictionaryException("Key does not exist");
        if(!dictionary.containsValue(value))
            throw new MyDictionaryException("Value does not exist");
        dictionary.remove(key, value);
    }*/

    public String toString(){
        StringBuilder s= new StringBuilder();
        for (HashMap.Entry<K, V> entry : dictionary.entrySet())
        {
            s.append(entry.getKey()).append(" ").append(entry.getValue()).append("\r\n");
        }
        return s.toString();
    }

    public K getKeyByValue(V value) {
        for (Map.Entry<K, V> entry : dictionary.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    public void update(K key, V val)throws MyDictionaryException{
        if(!dictionary.containsKey(key))
            throw new MyDictionaryException("Key does not exist");
        dictionary.replace(key, val);
    }

    public Collection<V> getValues()
    {
        return dictionary.values();
    }

    @Override
    public void setContent(Map newDict) {
        dictionary=newDict;
    }

    @Override
    public Map getContent() {
        return dictionary;
    }
}
