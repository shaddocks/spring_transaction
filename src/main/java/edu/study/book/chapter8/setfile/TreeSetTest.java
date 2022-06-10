package edu.study.book.chapter8.setfile;

import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        test02();
    }

    public static void test01(){
        TreeSet<B> treeSet = new TreeSet<>();
        treeSet.add(new B(1));
        treeSet.add(new B(2));
        treeSet.add(new B(2));
        treeSet.forEach(System.out::println);
    }

    public static void test02(){
        TreeSet<B> treeSet = new TreeSet<>((o1, o2) -> Integer.compare(o2.getId(), o1.getId()));
        treeSet.add(new B(1));
        treeSet.add(new B(2));
        treeSet.add(new B(2));
        treeSet.forEach(System.out::println);
    }
}
