package com.example.service.fanxing;

/**
 * Created by duguangquan on 2018/8/6.
 */
public class MymapImpl<K,V> implements Mymap<K,V>{

    private K key;
    private V value;

    public MymapImpl(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey()   { return key; }
    @Override
    public V getValue() { return value; }


    public static void main(String[] args) {
        Mymap<String, Integer> mp1= new MymapImpl<String, Integer>("Even", 8);
        Mymap<String, String>  mp2= new MymapImpl<String, String>("hello", "world");
        Mymap<Integer, Integer> mp3= new MymapImpl<Integer, Integer>(888, 888);

    }

}
