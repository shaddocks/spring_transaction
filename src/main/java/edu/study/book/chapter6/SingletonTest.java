package edu.study.book.chapter6;

public class SingletonTest {
    private static SingletonTest singletonTest;
    private SingletonTest(){}

    public static SingletonTest getInstance(){
        if (singletonTest == null) {
            singletonTest = new SingletonTest();
        }
        return singletonTest;
    }

    public static void main(String[] args){
        SingletonTest singletonTest1 = getInstance();
        SingletonTest singletonTest2 = getInstance();
        System.out.println(singletonTest1 == singletonTest2);
    }

    @Override
    public String toString() {
        return "SingletonTest{}";
    }
}
