package edu.study.book.chapter8.setfile;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {

    public static void main(String[] args) {
        test03();
    }

    public static void test01(){
        HashSet<A> hashSet = new HashSet<>();
        hashSet.add(new A());
        hashSet.add(new A());
        System.out.println(hashSet.size());
        hashSet.forEach(obj -> System.out.println(obj));
    }

    public static void test02(){
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("1");
        hashSet.add("2");
        hashSet.add("3");
        if (hashSet.contains("1")) {
            System.out.println(1);
        }
        if (!hashSet.isEmpty()) {
            System.out.println(hashSet.size());
        }
    }

    public static void test03(){
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("1");
        hashSet.add("2");
        hashSet.add("3");
        hashSet.forEach(obj -> System.out.println(obj));
        Iterator<String> iterator = hashSet.iterator();
        if (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        iterator.forEachRemaining(obj -> System.out.println(obj));
        for (String string: hashSet) {
            System.out.println(string);
        }
    }
}
