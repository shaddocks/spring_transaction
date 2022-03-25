package edu.study.book.chapter8;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.stream.IntStream;

public class CollectionsTest {

    public static void main(String[] args) {
        test04();
    }

    public static void test01(){
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
        arrayList.remove("4");
        System.out.println(arrayList.size());
        System.out.println(arrayList.contains("1"));
    }

    public static void test02(){
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("1");
        hashSet.add("2");
        hashSet.add("3");
        hashSet.forEach(obj -> System.out.println(obj));
    }

    public static void test03(){
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("1");
        hashSet.add("2");
        hashSet.add("3");
        Iterator<String> iterator = hashSet.iterator();
        iterator.forEachRemaining(obj -> System.out.println(obj));
        while (iterator.hasNext()){
            String string = iterator.next();
            System.out.println(string);
            if (string.equals("1")){
                iterator.remove();
            }
        }
        System.out.println(hashSet);
    }

    public static void test04(){
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("1");
        hashSet.add("2");
        hashSet.add("3");
        System.out.println(hashSet);
        hashSet.remove("1");
        System.out.println(hashSet);
        System.out.println(hashSet.isEmpty() + " " + hashSet.size());
        hashSet.forEach(obj -> System.out.print(obj + " "));
        System.out.println();
        Iterator<String> iterator = hashSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        hashSet.removeIf(element -> element.length() < 10);
        System.out.println(hashSet.size());

        hashSet.add("3");
        hashSet.add("4");
        hashSet.add("5");
        hashSet.add("6");
        hashSet.add("7");
        hashSet.stream().forEach(System.out::println);
        hashSet.stream().forEach(ele -> ele = "1");
        System.out.println(hashSet);
    }
    public static void test05(){
        IntStream.Builder builder = IntStream.builder();
        builder.add(1).add(2).add(3).add(4);
        IntStream intStream = builder.build();
        IntStream stream = intStream.map(element -> element * element);
        System.out.println(intStream.max().getAsInt());
        //System.out.println(intStream.min().getAsInt());
        //System.out.println(intStream.sum());
    }
}
