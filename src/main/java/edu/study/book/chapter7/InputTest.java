package edu.study.book.chapter7;

import java.io.*;
import java.time.Clock;
import java.time.ZoneId;
import java.util.Objects;
import java.util.Scanner;
import java.util.TimeZone;
import java.util.TreeSet;

public class InputTest {
    public static void main(String[] args) {
        test05();
    }

    public static void test01() { // Scanner类
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(scanner.next());
        }
    }

    public static void test02() {
        InputStream inputStream = null;
        System.out.println(Objects.hashCode(inputStream));
        System.out.println(Objects.toString(inputStream));
        System.out.println(Objects.requireNonNull(inputStream, "null"));
    }

    public static void test03() {
        String string = "google";
        System.out.println(string.charAt(1));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("java");
        stringBuilder.insert(0, "hello ");
        stringBuilder.replace(5, 6, ",");
        stringBuilder.delete(5, 6);
        System.out.println(Objects.toString(stringBuilder));
    }

    public static void test04() {
        Clock clock = Clock.systemUTC();
        System.out.println(clock.instant());
        System.out.println(clock.millis());
    }

    public static void test05() {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(12);
        treeSet.add(11);
        treeSet.add(10);
        treeSet.add(15);
        treeSet.add(17);
        System.out.println(treeSet);
        System.out.println(treeSet.first());
        System.out.println(treeSet.last());
        System.out.println(treeSet.subSet(10, 15));
    }
}
