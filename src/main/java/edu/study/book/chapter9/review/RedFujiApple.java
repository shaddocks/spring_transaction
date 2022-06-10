package edu.study.book.chapter9.review;

import java.util.Collection;

public class RedFujiApple extends Apple<String>{
    public RedFujiApple() {
    }

    public RedFujiApple(String info) {
        super(info);
    }

    @Override
    public void eat(String apple) {
        super.eat(apple + ": RedFujiApple");
    }

    public static <T> void fromArrayCollection1(T[] a, Collection<T> c) {
        for (T o: a) {
            c.add(o);
        }
    }

    public static <T> void test(Collection<? extends T> from, Collection<T> to) {
        for (T ele: from) {
            to.add(ele);
        }
    }

}
