package edu.study.book.chapter6.interfacefile;

public interface Output {
    int MAX_CACHE_LINE = 50;
    void out();
    void getData(String msg);

    default void print(String... messages) {
        for (String message: messages) {
            System.out.println(message);
        }
    }
    static void staticTest(){
        System.out.println("静态方法");
    }
}
