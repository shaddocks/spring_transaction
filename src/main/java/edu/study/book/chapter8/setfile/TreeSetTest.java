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
        treeSet.forEach(obj -> System.out.println(obj));
    }

    public static void test02(){
        TreeSet<B> treeSet = new TreeSet<>((o1, o2) -> {
            B b1 = (B)o1;
            B b2 = (B)o2;
            return b1.getId() > b2.getId()? -1:b1.getId() < b2.getId()? 1:0;
        });
        treeSet.add(new B(1));
        treeSet.add(new B(2));
        treeSet.add(new B(2));
        treeSet.forEach(obj -> System.out.println(obj));
    }
}
