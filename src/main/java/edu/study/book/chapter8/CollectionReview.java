package edu.study.book.chapter8;

import java.util.*;
import java.util.stream.Stream;

public class CollectionReview {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("1");
        set.add("2");
        set.add("3");
        set.add("4");
        set.add("5");
        set.add("6");
        test06();
    }

    public static void test01(HashSet<String> set) { //遍历容器类
        set.forEach(System.out::println);
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) System.out.print(iterator.next() + "  ");
        for (String string: set) System.out.print(string + "  ");
    }

    public static void test02(HashSet<String> set) { //collections一些操作
        set.remove("2");
        set.retainAll(new HashSet<>(set));
        System.out.println(set.isEmpty());
        System.out.println(set.size());
        System.out.println(set.contains("2"));
        set.clear();
    }

    public static void test03() { // TreeSet
        //HashSet equals && hashCode
        TreeSet<String> treeSet = new TreeSet<>(Comparator.comparingInt(String::length));
        treeSet.add("1");
        treeSet.add("12");
        treeSet.add("123");
        treeSet.add("1234");
        treeSet.add("12345");
        System.out.println(treeSet.last());
    }

    public static void test04() { //Queue
        Deque<String> deque = new ArrayDeque<>();
        deque.offer("1");
        deque.offer("2");
        deque.offer("3");
        deque.offer("4");
        deque.offer("5");
        System.out.println(deque.peek());
        System.out.println(deque.poll());
        deque.push("12");
        System.out.println(deque.pop());
    }

    public static void test05() { //List
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(2);
        arrayList.add(5);
        arrayList.add(4);
        arrayList.sort(Integer::compare);
        System.out.println(arrayList);
    }

    public static void test06() { //map
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "1");
        hashMap.put(2, "2");
        hashMap.put(3, "3");
        hashMap.put(4, "4");
        hashMap.put(5, "5");
        hashMap.put(6, "6");
        hashMap.remove(6);
        System.out.println(hashMap.get(1));
        System.out.println(hashMap.isEmpty());
        System.out.println(hashMap.size());
        System.out.println(hashMap.containsKey(1));
        for (int i: hashMap.keySet()) System.out.print(hashMap.get(i) + "  ");
        System.out.println();
        for (Map.Entry<Integer, String> entry: hashMap.entrySet()) {
            System.out.println(entry.getKey() + "  " + entry.getValue());
        }
    }

    public static void test07(HashSet<String> set) {
        Stream<String> stream = set.stream();
        String[] strings = stream.toArray(String[]::new);
    }
}
