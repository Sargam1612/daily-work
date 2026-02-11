package com.zeta;

import java.util.HashMap;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static void customKey(){
        Map<MyKey,String> map = new HashMap<>();
        MyKey mykey = new MyKey();
        MyKey mykey1 = new MyKey();
        map.put(mykey,"value1");
        map.put(mykey1,"value2");
        System.out.println(map.get(mykey));
        System.out.println(map.get(mykey1));

    }
    private static void basics(){
        Map<String,String> map = new HashMap<>();
        map.put("1","value1");
        map.put("3","value3");
        System.out.println(map.put("1","value2"));
        System.out.println(map.put("2","value2"));
    }

    public static void main(String[] args) {
        basics();
        customKey();;
    }


    private static class MyKey {
    }
}