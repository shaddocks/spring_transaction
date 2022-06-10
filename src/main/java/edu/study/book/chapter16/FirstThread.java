package edu.study.book.chapter16;

public class FirstThread extends Thread{
    private int i;

    @Override
    public void run(){
        for (; i < 100; ++i) {
            System.out.println(getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        new FirstThread().start();
        new FirstThread().start();
        //new Thread().start();
    }
}
