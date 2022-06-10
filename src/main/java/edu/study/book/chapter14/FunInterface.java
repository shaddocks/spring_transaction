package edu.study.book.chapter14;

@FunctionalInterface
public interface FunInterface {
    void printString();
    default void describeInterface() {
        System.out.println("interface");
    }
}
