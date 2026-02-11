package com.zeta;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapDemo {

    private static void customKey() {
        Map<MyKey, String> map = new TreeMap<>();
        MyKey mykey = new MyKey();
        MyKey mykey1 = new MyKey();
        map.put(mykey, "value1");
        map.put(mykey1, "value2");
        System.out.println(map.get(mykey));
        System.out.println(map.get(mykey1));
        System.out.println(map.remove(null));

    }

    private static void basics() {
        Map<String, String> map = new HashMap<>();
        map.put("1", "value1");
        map.put("3", "value3");
        System.out.println(map.put("1", "value2"));
        System.out.println(map.put("2", "value2")); //map.put->
        //It inserts or updates the value for that key
        //It returns the previous value associated with that key
        map.forEach((key, value) -> System.out.println(value));
    }

    public static void main(String[] args) {
        basics();
        customKey();
        ;

    }
}