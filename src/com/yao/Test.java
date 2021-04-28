package com.yao;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @version 1.0
 * @author： 姚文宇 -m
 * @date： 2021-04-27 20:18
 */
public class Test {
    static int a = 10;

    public static void test1(){
         a  = 10;
    }

    private static void test2(){
       a = 100;
    }

    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(null,"dhjsd");
        hashMap.put(null,null);

        for (Map.Entry<String, String> stringStringEntry : hashMap.entrySet()) {
            System.out.println(stringStringEntry.getKey()+"-----"+stringStringEntry.getValue());
        }

        System.out.println("--------------------------");

        HashSet<String> strings = new HashSet<>();
        strings.add(null);
        strings.add("wqdde");
        strings.add(null);
        strings.forEach(System.out::println);
    }
}
