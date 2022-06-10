package edu.study.book.chapter9.review;

public class Apple<T> {
    private T info;

    public Apple() {
    }

    public Apple(T info) {
        this.info = info;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public void eat(T apple) {
        System.out.println("Apple: " + apple);
    }

    @Override
    public String toString() {
        return "Apple{" +
                "info=" + info +
                '}';
    }
}
