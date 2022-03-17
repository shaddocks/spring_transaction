package edu.study.book.chapter6.lambda;

@FunctionalInterface
public interface Command {
    void process(int target);
}
