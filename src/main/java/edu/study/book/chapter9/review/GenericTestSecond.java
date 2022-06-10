package edu.study.book.chapter9.review;

public class GenericTestSecond {
    public static void main(String[] args) {
        test01();
    }

    public static void test01() {
        Apple<String> a1 = new Apple<>("苹果");
        Apple<Double> a2 = new Apple<>(1.5);
        System.out.println(a1);
        System.out.println(a2);
    }
}
