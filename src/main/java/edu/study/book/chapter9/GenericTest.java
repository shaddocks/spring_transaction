package edu.study.book.chapter9;

public class GenericTest {
    public static void main(String[] args) {

    }

    public static void test01(){
        FunctionTest<String> functionTest = new FunctionTest<String>() {
            @Override
            public void test(String s) {
                System.out.println(s);
            }
        };
        FunctionTest<?> functionTest1 = new FunctionTest<Object>() {
            @Override
            public void test(Object o) {

            }
        };

        FunctionTest<String> functionTest2 = (String s) -> System.out.println(s);
    }
}
