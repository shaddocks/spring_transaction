package edu.study.book.chapter16;

import java.util.concurrent.Callable;

public class CallableTest<T> implements Callable<T> {
    private int i = 0;
    @Override
    public T call() throws Exception {
        i++;
        System.out.println(Thread.currentThread().getName() + " " + i);
        return null;
    }
}
