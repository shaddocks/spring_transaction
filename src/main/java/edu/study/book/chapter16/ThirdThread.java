package edu.study.book.chapter16;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class ThirdThread {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> task = new FutureTask<>((Callable<Integer>)() -> {
            Integer i = 0;
            for (; i < 100; ++i) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
            return i;
        });
        new Thread(task).start();
        System.out.println(task.get());

        final CallableTest<Integer> integerCallableTest = new CallableTest<>();
        FutureTask<Integer> task1 = new FutureTask<>(integerCallableTest);
        FutureTask<Integer> task2 = new FutureTask<>(integerCallableTest);
        new Thread(task1).start();
        Thread.sleep(100);
        new Thread(task2).start();
    }
}
