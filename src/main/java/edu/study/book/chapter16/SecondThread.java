package edu.study.book.chapter16;

public class SecondThread implements Runnable{
    private int i;
    @Override
    public void run() {
        for (; i < 100; ++i) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }


    public static void main(String[] args) {
        Runnable target = new SecondThread();
        new Thread(target).start();
        new Thread(target).start();
        new Thread(() -> System.out.println("lambda")).start();
    }
}
