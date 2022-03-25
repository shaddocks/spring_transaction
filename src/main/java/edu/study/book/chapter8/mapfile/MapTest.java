package edu.study.book.chapter8.mapfile;

import java.util.*;

public class MapTest {
    public static void main(String[] args) {
        test01();
    }

    public static void test01(){
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "1");
        hashMap.put(2, "2");
        hashMap.put(2, "3");
        System.out.println(hashMap.containsKey(1));
        System.out.println(hashMap.containsValue("1"));
        hashMap.forEach((key, value) -> System.out.println(key + ": " + value));
        for (Integer key: hashMap.keySet()) {
            System.out.println(key + ": " + hashMap.get(key));
        }
        Set<Map.Entry<Integer, String>> set = hashMap.entrySet();
        Iterator<Map.Entry<Integer, String>> iterator = set.iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, String> next = iterator.next();
            next.setValue("1");
        }
        System.out.println(hashMap);
    }
}
