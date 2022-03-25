package edu.study.book.chapter8.listfile;

import java.util.ArrayList;

public class ListTest {
    public static void main(String[] args) {
        test01();
    }

    public static void test01(){
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add(1, "new 2");
        arrayList.forEach(obj -> System.out.println(obj));
        arrayList.remove(1);
        arrayList.forEach(obj -> System.out.println(obj));
    }
}
