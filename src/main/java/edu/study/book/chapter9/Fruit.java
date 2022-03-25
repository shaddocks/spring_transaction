package edu.study.book.chapter9;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Fruit<T extends Object>{
    private T info;
    public Fruit(T info){
        this.info = info;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public void test1(List<? extends Integer> list){
        for (int i = 0; i < list.size(); ++i){
            System.out.println(list.get(i));
        }
    }
    public void test2(List<? super Integer> list){
        list.add(new Integer(1));
    }

    public static <T> void test3(T a, Collection<T> b){
        //System.out.println(a);
    }

    public static <T> T copy(Collection<? super T> dest, Collection<T> src){
        return null;
    }

    public static void main(String[] args) {
        Fruit<String> fruit1 = new Fruit<>("fruit");
        Fruit<Double> fruit2 = new Fruit<>(1.23);
        fruit1.test2(new ArrayList<Number>());

        Fruit<?> fruit = new Fruit<>(12);
        System.out.println(fruit.getInfo());
        //fruit.setInfo("12");

        test3(12, new ArrayList<Object>());
    }
}
